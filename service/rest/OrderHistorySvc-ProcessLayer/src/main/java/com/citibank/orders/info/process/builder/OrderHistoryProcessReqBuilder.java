package com.citibank.orders.info.process.builder;

import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;

public class OrderHistoryProcessReqBuilder {

	public OrderHistoryDAOReqBean buildDaoReq(OrderHistoryProcessReqBean processReq) {

		OrderHistoryDAOReqBean daoReq = new OrderHistoryDAOReqBean();

		daoReq.setChannelId(processReq.getChannelId());
		daoReq.setClientId(processReq.getClientId());
		daoReq.setNameOnCard(processReq.getNameOnCard());
		daoReq.setPrice(processReq.getPrice());
		daoReq.setStartDate(processReq.getStartDate());
		daoReq.setTypeOfOrder(processReq.getTypeOfOrder());
		daoReq.setCardNumber(processReq.getCardNum());
		daoReq.setCvvNum(processReq.getCvvNum());
		daoReq.setEndDate(processReq.getEndDate());
		daoReq.setExpDate(processReq.getExpDate());

		return daoReq;
	}
}
