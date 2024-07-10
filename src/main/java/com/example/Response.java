package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("rules")
	private List<RulesItem> rules;

	@JsonProperty("version")
	private double version;

	public List<RulesItem> getRules(){
		return rules;
	}

	public double getVersion(){
		return version;
	}
}