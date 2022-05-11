package com.example.testekwateur.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PromoCode {
	private String code;
	private Integer discountValue;
	private String endDate;
	
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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	// TODO : Method should be moved to a "service" for a global usage
	public boolean isDatePast(final String date, final String dateFormat) {
		LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate inputDate = LocalDate.parse(date, dtf);

		return inputDate.isBefore(localDate);
	}


}
