package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesItem{

	@JsonProperty("condition")
	private List<ConditionItem> condition;

	@JsonProperty("rule")
	private String rule;

	@JsonProperty("steps")
	private List<StepsItem> steps;

	public List<ConditionItem> getCondition(){
		return condition;
	}

	public String getRule(){
		return rule;
	}

	public List<StepsItem> getSteps(){
		return steps;
	}
}