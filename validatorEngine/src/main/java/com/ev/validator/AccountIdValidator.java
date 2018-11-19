package com.ev.validator;

import org.springframework.stereotype.Component;

import com.ev.model.BusinessException;
import com.ev.model.Predicates;
@Component
public class AccountIdValidator {

	public Predicates<String> isValidAccountId(String id,String validName){
        return () -> { System.out.println("isValidAccountId Validator Executed !!");
        	if(validName!=id) {System.out.println("Invalid ID Entered"); return false;}
        						System.out.println("ID: "+ id+"  ,  Name: "+validName);
        			return true;};
    }
	
}
