package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StepsItem{

	@JsonProperty("action")
	private String action;

	@JsonProperty("intent")
	private String intent;

	@JsonProperty("slot_was_set")
	private List<SlotWasSetItem> slotWasSet;

	@JsonProperty("or")
	private List<OrItem> or;

	public String getAction(){
		return action;
	}

	public String getIntent(){
		return intent;
	}

	public List<SlotWasSetItem> getSlotWasSet(){
		return slotWasSet;
	}

	public List<OrItem> getOr(){
		return or;
	}
}