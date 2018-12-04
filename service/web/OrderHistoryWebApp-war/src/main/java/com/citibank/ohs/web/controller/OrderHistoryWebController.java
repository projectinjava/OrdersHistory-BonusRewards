package com.citibank.ohs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citibank.ohs.service.client.OrderHistoryServiceClient;
import com.citibank.ohs.service.client.beans.CardDetails;
import com.citibank.ohs.service.client.beans.DateRange;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;
import com.citibank.ohs.service.client.beans.OrdersInfo;
import com.citibank.ohs.service.client.impl.OrderHistoryServiceClientImpl;
import com.citibank.ohs.web.beans.OrderHistoryWebReqBeans;
import com.citibank.ohs.web.beans.OrderHistoryWebResBeans;

@Controller
public class OrderHistoryWebController {

	@RequestMapping(value = "/getOrders")

	// public ModelAndView getOrderHistory(OrderHistoryWebReqBeans webReq) {
	public String getOrderHistory(OrderHistoryWebReqBeans webReq) {

		String page = "sucess.jsp";

		try {
			// get the webrequest from user
			// prepare the werservice request for client
			OrderHistoryWebSvcReq svcReq = new OrderHistoryWebSvcReq();

			CardDetails cardDetails = new CardDetails();
			cardDetails.setCardNumber(webReq.getCardNumber());
			cardDetails.setCvvNum(webReq.getCvvNum());
			cardDetails.setExpDate(webReq.getExpDate());
			cardDetails.setNameOnCard(webReq.getNameOnCard());

			DateRange dateRange = new DateRange();
			dateRange.setEndDate(webReq.getEndDate());
			dateRange.setStartDate(webReq.getStartDate());

			OrdersInfo ordersInfo = new OrdersInfo();
			ordersInfo.setPrice(Double.valueOf(webReq.getPrice()));
			ordersInfo.setTypeOfOrder(webReq.getTypeOfOrder());

			svcReq.setCardDetails(cardDetails);
			svcReq.setDateRange(dateRange);
			svcReq.setOrdersInfo(ordersInfo);

			// create the webservice client obj
			OrderHistoryServiceClient svcClient = new OrderHistoryServiceClientImpl();
			// call the webservice client by passing wsreq obj and get the wsresp
			OrderHistoryWebSvcRes wsResp = svcClient.getOrderHistory(svcReq);
			// convert the wsResp to webResp
			OrderHistoryWebResBeans webresp = new OrderHistoryWebResBeans();
			// store the webresp into sessions or request scope
		} catch (Exception e) {
			page = "failure.jsp";
			e.printStackTrace();
		}

		return page;
	}

}
