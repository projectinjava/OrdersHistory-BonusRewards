package com.citibank.orders.info.dao.beans;

public class OrderDetailsDAO {
	
	private String oid;
	private String name;
	private String desc;
	private String date;
	private String status;
	private String type;
	private String price;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetailsDAO [oid=" + oid + ", name=" + name + ", desc=" + desc + ", date=" + date + ", status="
				+ status + ", type=" + type + ", price=" + price + "]";
	}
	
	

}
