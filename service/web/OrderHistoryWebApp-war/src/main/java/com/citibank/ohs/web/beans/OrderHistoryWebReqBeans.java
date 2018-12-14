package com.citibank.ohs.web.beans;

public class OrderHistoryWebReqBeans {

	private String cardNumber;
	private String cvvNum;
	private String nameOnCard;
	private String expDate;
	private String startDate;
	private String endDate;
	private String price;
	private String typeOfOrder;

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

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTypeOfOrder() {
		return typeOfOrder;
	}

	public void setTypeOfOrder(String typeOfOrder) {
		this.typeOfOrder = typeOfOrder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryWebReqBeans [cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNum=");
		builder.append(cvvNum);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", price=");
		builder.append(price);
		builder.append(", typeOfOrder=");
		builder.append(typeOfOrder);
		builder.append("]");
		return builder.toString();
	}

}
