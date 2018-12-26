package com.citibank.orders.info.process.beans;

public class OrderHistoryProcessReqBean {
	
	private String clientId;
	private String channelId;
	private String requestId;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	private String cardNum;
	private String cvvNum;
	private String expDate;
	private String nameOnCard;
	private String startDate;
	private String endDate;
	private String typeOfOrder;
	private Double price;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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
	public String getTypeOfOrder() {
		return typeOfOrder;
	}
	public void setTypeOfOrder(String typeOfOrder) {
		this.typeOfOrder = typeOfOrder;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryProcessReqBean [clientId=");
		builder.append(clientId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", cardNum=");
		builder.append(cardNum);
		builder.append(", cvvNum=");
		builder.append(cvvNum);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", typeOfOrder=");
		builder.append(typeOfOrder);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
}
