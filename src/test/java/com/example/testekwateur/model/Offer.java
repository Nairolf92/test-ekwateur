package com.example.testekwateur.model;

import java.util.ArrayList;

public class Offer {
	
	private String offerType;
	private String offerName;
	private String offerDescription;
    private ArrayList<String> validPromoCodeList = new ArrayList<String>();
    
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public ArrayList<String> getValidPromoCodeList() {
		return validPromoCodeList;
	}
	public void setValidPromoCodeList(ArrayList<String> validPromoCodeList) {
		this.validPromoCodeList = validPromoCodeList;
	}
 
}
