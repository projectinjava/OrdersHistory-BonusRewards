package com.citibank.ohs.service.client.beans;

public class OrderHistoryWebSvcRes {

	private StatusBlock statusBlock;
	private OrderHistoryDetails orderHistoryDetails;
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}
	public OrderHistoryDetails getOrderHistoryDetails() {
		return orderHistoryDetails;
	}
	public void setOrderHistoryDetails(OrderHistoryDetails orderHistoryDetails) {
		this.orderHistoryDetails = orderHistoryDetails;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryWebSvcRes [statusBlock=");
		builder.append(statusBlock);
		builder.append(", orderHistoryDetails=");
		builder.append(orderHistoryDetails);
		builder.append("]");
		return builder.toString();
	}
	
	
}
