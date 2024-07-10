package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlotWasSetItem{

	@JsonProperty("test-condition")
	private boolean testCondition;

	@JsonProperty("list-has-slot-lk-parolx-ne-prihodit-DEVICE")
	private Object listHasSlotLkParolxNePrihoditDEVICE;

	@JsonProperty("segment-group-b2x")
	private Object segmentGroupB2x;

	@JsonProperty("infl-lk-parolx-ne-prihodit-LICHNYY-KABINET")
	private Object inflLkParolxNePrihoditLICHNYYKABINET;

	@JsonProperty("id-zaprety-uslug")
	private Object idZapretyUslug;

	@JsonProperty("zapret-vhod-sms")
	private Object zapretVhodSms;

	@JsonProperty("id_SMS")
	private Object idSMS;

	@JsonProperty("usluga-SMS")
	private Object uslugaSMS;

	@JsonProperty("list-has-slot-lc")
	private Object listHasSlotLc;

	@JsonProperty("zapret-SMS-zamena-sim")
	private String zapretSMSZamenaSim;

	@JsonProperty("list-has-slot-sms-company")
	private Object listHasSlotSmsCompany;

	@JsonProperty("is-slot-in-list-lc-finblocks")
	private Object isSlotInListLcFinblocks;

	@JsonProperty("zapret-kont-nomerov")
	private Object zapretKontNomerov;

	@JsonProperty("zapret-ishod-sms")
	private Object zapretIshodSms;

	public boolean isTestCondition(){
		return testCondition;
	}

	public Object getListHasSlotLkParolxNePrihoditDEVICE(){
		return listHasSlotLkParolxNePrihoditDEVICE;
	}

	public Object getSegmentGroupB2x(){
		return segmentGroupB2x;
	}

	public Object getInflLkParolxNePrihoditLICHNYYKABINET(){
		return inflLkParolxNePrihoditLICHNYYKABINET;
	}

	public Object getIdZapretyUslug(){
		return idZapretyUslug;
	}

	public Object getZapretVhodSms(){
		return zapretVhodSms;
	}

	public Object getIdSMS(){
		return idSMS;
	}

	public Object getUslugaSMS(){
		return uslugaSMS;
	}

	public Object getListHasSlotLc(){
		return listHasSlotLc;
	}

	public String getZapretSMSZamenaSim(){
		return zapretSMSZamenaSim;
	}

	public Object getListHasSlotSmsCompany(){
		return listHasSlotSmsCompany;
	}

	public Object getIsSlotInListLcFinblocks(){
		return isSlotInListLcFinblocks;
	}

	public Object getZapretKontNomerov(){
		return zapretKontNomerov;
	}

	public Object getZapretIshodSms(){
		return zapretIshodSms;
	}
}