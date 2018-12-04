package com.citibank.orders.info.service.beans;

public class OrderHistoryServiceResBean {

	private StatusBlock statusBlock;
	private OrderHistoryDetails orderHistoryDetails;

	public OrderHistoryDetails getOrderHistoryDetails() {
		return orderHistoryDetails;
	}

	public void setOrderHistoryDetails(OrderHistoryDetails orderHistoryDetails) {
		this.orderHistoryDetails = orderHistoryDetails;
	}

	public StatusBlock getStatusBlock() {
		return statusBlock;
	}

	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHistoryServiceResBean [statusBlock=");
		builder.append(statusBlock);
		builder.append(", orderHistoryDetails=");
		builder.append(orderHistoryDetails);
		builder.append("]");
		return builder.toString();
	}

}
