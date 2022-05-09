package com.example.testekwateur.model;

import java.util.Date;

public class PromoCode {
	private String code;
	private Integer discountValue;
	private Date endDate;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(Integer discountValue) {
		this.discountValue = discountValue;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
