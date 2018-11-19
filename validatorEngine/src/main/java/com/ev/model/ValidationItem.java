package com.ev.model;

import org.springframework.stereotype.Component;

@Component
public class ValidationItem<T> {

	private T validationInput;
	private Predicates predicate;
	private String validationType;

	public T getValidationInput() {
		return validationInput;
	}

	public void setValidationInput(T validationInput) {
		this.validationInput = validationInput;
	}

	public Predicates getPredicates() {
		return predicate;
	}

	public void setPredicates(Predicates predicate) {
		this.predicate = predicate;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}

}
