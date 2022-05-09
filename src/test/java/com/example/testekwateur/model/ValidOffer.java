package com.example.testekwateur.model;

import java.util.ArrayList;
import java.util.Date;

public class ValidOffer {

    private String promoCodeText;
    private Date endDate;
    private Double discountValue;
    private ArrayList<CompatibleOffer> compatibleOfferList = new ArrayList<CompatibleOffer>();
    
	public String getPromoCodeText() {
		return promoCodeText;
	}
	public void setPromoCodeText(String promoCodeText) {
		this.promoCodeText = promoCodeText;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}
	public ArrayList<CompatibleOffer> getCompatibleOfferList() {
		return compatibleOfferList;
	}
	public void setCompatibleOfferList(ArrayList<CompatibleOffer> compatibleOfferList) {
		this.compatibleOfferList = compatibleOfferList;
	}
}