package com.citibank.ohs.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.citibank.ohs.service.client.OrderHistoryServiceClient;
import com.citibank.ohs.service.client.beans.CardDetails;
import com.citibank.ohs.service.client.beans.DateRange;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;
import com.citibank.ohs.service.client.beans.OrdersInfo;
import com.citibank.ohs.service.client.impl.OrderHistoryServiceClientImpl;
import com.citibank.ohs.web.beans.OrderCmd;
import com.citibank.ohs.web.beans.OrderHistoryWebReqBeans;
import com.citibank.ohs.web.beans.OrderHistoryWebResBeans;
import com.citibank.ohs.web.beans.Orders;

@Controller
public class OrderHistoryWebController {

	@PostMapping(value = "/getOrders")

	// public ModelAndView getOrderHistory(OrderHistoryWebReqBeans webReq) {
	public String getOrderHistory(Model model, @ModelAttribute("orderCmd") OrderCmd cmd,OrderHistoryWebReqBeans webReq) {

		String page = "sucess";

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
			OrderHistoryWebResBeans webResp = new OrderHistoryWebResBeans();
			
			List<Orders> ordersList=new ArrayList<Orders>();
			Orders order=new Orders();
			order.setDate(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getDate());
			order.setDesc(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getDesc());
			order.setName(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getName());
			order.setOid(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getOid());
			order.setPrice(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getPrice());
			order.setStatus(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getStatus());
			order.setType(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getType());
			ordersList.add(order);
			
			webResp.setOrders(ordersList);
			webResp.setRespCode(wsResp.getStatusBlock().getRespCode());
			webResp.setRespmsg(wsResp.getStatusBlock().getRespMessage());
			// store the webresp into sessions or request scope
			model.addAttribute("result", webResp);
		} catch (Exception e) {
			page = "failure";
			e.printStackTrace();
		}

		return page;
	}

}
