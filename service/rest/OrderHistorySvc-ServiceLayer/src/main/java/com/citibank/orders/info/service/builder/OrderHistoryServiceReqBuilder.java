package com.citibank.orders.info.service.builder;

import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;

public class OrderHistoryServiceReqBuilder {

	public OrderHistoryProcessReqBean buildProcessReq(OrderHistoryServiceReqBean serviceReq) {
		
		OrderHistoryProcessReqBean processReq=new OrderHistoryProcessReqBean();
		processReq.setClientId(serviceReq.getClientContext().getClientId());
		processReq.setChannelId(serviceReq.getClientContext().getChannelId());
		processReq.setCardNum(serviceReq.getCardDetails().getCardNumber());
		processReq.setCvvNum(serviceReq.getCardDetails().getCvvNum());
		processReq.setNameOnCard(serviceReq.getCardDetails().getNameOnCard());
		processReq.setExpDate(serviceReq.getCardDetails().getExpDate());
		
		if(serviceReq.getDateRange().getStartDate()==null && serviceReq.getDateRange().getEndDate()==null) {
			String startDate=" "; // last 60 days
			String endDate =" "; // current date
			
			processReq.setStartDate(startDate);
			processReq.setEndDate(endDate);
		}else {
			processReq.setStartDate(serviceReq.getDateRange().getStartDate());
			processReq.setEndDate(serviceReq.getDateRange().getEndDate());
		}
		processReq.setTypeOfOrder(serviceReq.getOrdersInfo().getTypeOfOrder());
		processReq.setPrice(Double.valueOf(serviceReq.getOrdersInfo().getPrice()));
		
		return processReq;
	}
	
	

}
