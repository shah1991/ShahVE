package com.ev.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationListItems {

	private Predicates isValidAccountid;
	private Predicates isAmountlimitValid;
	private List<String> errorCodes;
	
	
	
	
	public ValidationListItems() {
		this.isValidAccountid=null;
		this.isAmountlimitValid=null;
		this.setErrorCodes(new ArrayList());
	}
	public Predicates getIsValidAccountid() {
		return isValidAccountid;
	}
	public void setIsValidAccountid(Predicates isValidAccountid) {
		this.isValidAccountid = isValidAccountid;
	}
	public Predicates getIsAmountlimitValid() {
		return isAmountlimitValid;
	}
	public void setIsAmountlimitValid(Predicates isAmountlimitValid) {
		this.isAmountlimitValid = isAmountlimitValid;
	}
	public List getErrorCodes() {
		return errorCodes;
	}
	public void setErrorCodes(List errorCodes) {
		this.errorCodes=errorCodes;
	}
	public void addErrorCode(String errorCode) {
		this.getErrorCodes().add(errorCode);
	}
	
	
}
