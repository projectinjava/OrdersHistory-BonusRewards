package com.citibank.ohs.service.client.beans;

public class CardDetails {
	
	private String cardNumber;
	private String cvvNum;
	private String expDate;
	private String nameOnCard;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvvNum() {
		return cvvNum;
	}
	public void setCvvNum(String cvvNum) {
		this.cvvNum = cvvNum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cvvNum=" + cvvNum + ", expDate=" + expDate + ", nameOnCard="
				+ nameOnCard + "]";
	}
	
	

}
