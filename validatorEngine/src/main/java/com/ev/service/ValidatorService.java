package com.ev.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.MultiMap;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.ev.ValidatorEngine.ValidatorEngine;
import com.ev.config.ResourceBundleSource;
import com.ev.constant.Constants;
import com.ev.model.Predicates;
import com.ev.model.ValidationListItems;
import com.ev.validator.AccountIdValidator;
import com.ev.validator.AmountValidator;

@Service
public class ValidatorService {

	@Autowired
	private ValidatorEngine engine;

	@Autowired
	private AccountIdValidator idValidator;

	@Autowired
	private AmountValidator amtValidator;

	@Autowired
	private ResourceBundleSource messageSource;

	public void serviceCall() {

		Locale locale = new Locale("en");
		
		
		/*
		 
		System.out.println("Enter AccountId");
		 
		Scanner s = new Scanner(System.in);

		engine.addValidator(idValidator.isValidAccountId(s.next(), Constants.ACCOUNT_ID),
				Constants.VALIDATION_MANDATORY);

		System.out.println("Enter the amount");
		s = new Scanner(System.in);

		engine.addValidator(amtValidator.isAmountLimitValid(s.nextDouble(), Constants.AMOUNT_LIMIT),
				Constants.VALIDATION_DEPENDENT);
				
		MultiMap errors = engine.validate();
		
		System.out.println("");
		errors.forEach((k, v) -> System.out.println("ValidationType : " + k + " Error Message : " + v));

		 */
		KieSession kSession =null;
		try {
			
		
		Predicates<String> isValidAccountid = idValidator.isValidAccountId("ABC123", Constants.ACCOUNT_ID);
		Predicates isAmountlimitValid = amtValidator.isAmountLimitValid(1000000.0, Constants.AMOUNT_LIMIT);
		
		
		ValidationListItems listItem= new ValidationListItems();
		listItem.setIsAmountlimitValid(isAmountlimitValid);
		listItem.setIsValidAccountid(isValidAccountid);
		
		kSession = getSession();

		kSession.insert(listItem);
		kSession.fireAllRules();

		
		listItem.getErrorCodes().stream().forEach(System.out::print);

		

		/* errors.forEach((k,v)->v=messageSource.getSource().getMessage(v, locale)); */

		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			kSession.dispose();
		}
	}

	public static KieSession getSession() {
		try {
			
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieBase kBase = kContainer.getKieBase("currency");
			return kBase.newKieSession();
			/*
			 * kSession.addEventListener(new DebugAgendaEventListener());
			 * kSession.addEventListener(new DebugRuleRuntimeEventListener());
			 */

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}
