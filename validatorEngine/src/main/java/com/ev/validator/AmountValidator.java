package com.ev.validator;

import org.springframework.stereotype.Component;

import com.ev.model.BusinessException;
import com.ev.model.Predicates;
@Component
public class AmountValidator {

	public Predicates isAmountLimitValid(Double amt,Double limit) {
        return () -> {System.out.println("isAmountLimitValid Validator is executed");
        	if(limit < amt) {System.out.println("Amount Exceeded");return false;}
        				System.out.println("LIMIT: "+ limit+"  ,  Amount: "+amt);
        				return true;};
    }
}
