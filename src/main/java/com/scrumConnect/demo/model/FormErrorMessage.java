package com.scrumConnect.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormErrorMessage {

	Map<String, List<String>> error = new HashMap<String, List<String>>();
	String errorDetail;
	
	public Map<String, List<String>> getError() {
		return error;
	}
	public void setError(Map<String, List<String>> error) {
		this.error = error;
	}
	public String getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
	
	
}
