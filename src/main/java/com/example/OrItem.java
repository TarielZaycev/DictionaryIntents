package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrItem{

	@JsonProperty("intent")
	private String intent;

	public String getIntent(){
		return intent;
	}
}