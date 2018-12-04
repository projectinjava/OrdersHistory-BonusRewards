package com.citibank.ohs.service.client.beans;

public class OrdersInfo {
	
	private String typeOfOrder;
	private double price;
	public String getTypeOfOrder() {
		return typeOfOrder;
	}
	public void setTypeOfOrder(String typeOfOrder) {
		this.typeOfOrder = typeOfOrder;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrdersInfo [typeOfOrder=" + typeOfOrder + ", price=" + price + "]";
	}
	

}
