package com.citibank.orders.info.service.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderHistoryServiceResBean {

	private StatusBlock statusBlock;
	private List<OrderHistory> orderHistory;
	private OrderHistoryDetails orderHistoryDetails;

	
	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}

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
		builder.append(", orderHistory=");
		builder.append(orderHistory);
		builder.append(", orderHistoryDetails=");
		builder.append(orderHistoryDetails);
		builder.append("]");
		return builder.toString();
	}

}
