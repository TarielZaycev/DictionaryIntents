package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionItem{

	@JsonProperty("slot_was_set")
	private List<SlotWasSetItem> slotWasSet;

	public List<SlotWasSetItem> getSlotWasSet(){
		return slotWasSet;
	}
}