package com.citibank.ohs.service.client.beans;

import java.util.List;

public class OrderHistoryWebSvcRes {

	private StatusBlock statusBlock;
	private OrderHistoryDetails orderHistoryDetails;
	private List<OrderHistory> orderHistory;

	
	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}

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
		builder.append(", orderHistory=");
		builder.append(orderHistory);
		builder.append("]");
		return builder.toString();
	}

	
}
