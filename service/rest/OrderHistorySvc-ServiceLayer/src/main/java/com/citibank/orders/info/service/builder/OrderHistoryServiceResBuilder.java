package com.citibank.orders.info.service.builder;

import java.util.ArrayList;
import java.util.List;

import com.citibank.orders.info.process.beans.OrderDetailsProcessBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessResBean;
import com.citibank.orders.info.service.beans.OrderHistory;
import com.citibank.orders.info.service.beans.OrderHistoryDetails;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.beans.StatusBlock;

public class OrderHistoryServiceResBuilder {

	public OrderHistoryServiceResBean buildServiceResponse(OrderHistoryProcessResBean processResp) {

		OrderHistoryServiceResBean serviceResp = new OrderHistoryServiceResBean();

		// 6. prepare the service layer response

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(processResp.getRespCode());
		statusBlock.setRespMessage(processResp.getRespMesssage());

		OrderHistoryDetails orderDetails = new OrderHistoryDetails();
		List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();

		List<OrderDetailsProcessBean> processOrderList = processResp.getOrderDetailsProcessBean();
		for (OrderDetailsProcessBean orderDetailsProcessBean : processOrderList) {

			OrderHistory orderHistory = new OrderHistory();
			orderHistory.setOid(orderDetailsProcessBean.getOid());
			orderHistory.setName(orderDetailsProcessBean.getName());
			orderHistory.setDesc(orderDetailsProcessBean.getDesc());
			orderHistory.setDate(orderDetailsProcessBean.getDate());
			orderHistory.setPrice(orderDetailsProcessBean.getPrice());
			orderHistory.setStatus(orderDetailsProcessBean.getStatus());
			orderHistory.setType(orderDetailsProcessBean.getType());

			orderHistoryList.add(orderHistory);

		}
		orderDetails.setOrderHistory(orderHistoryList);

		// 7. set the serviceResp using processResp

		serviceResp.setStatusBlock(statusBlock);
		serviceResp.setOrderHistoryDetails(orderDetails);

		return serviceResp;
	}

}