package com.citibank.ohs.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citibank.ohs.service.client.OrderHistoryServiceClient;
import com.citibank.ohs.service.client.beans.CardDetails;
import com.citibank.ohs.service.client.beans.DateRange;
import com.citibank.ohs.service.client.beans.OrderHistory;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcReq;
import com.citibank.ohs.service.client.beans.OrderHistoryWebSvcRes;
import com.citibank.ohs.service.client.beans.OrdersInfo;
import com.citibank.ohs.service.client.beans.ServiceDetails;
import com.citibank.ohs.service.client.beans.StatusBlock;
import com.citibank.ohs.service.client.impl.OrderHistoryServiceClientImpl;
import com.citibank.ohs.web.beans.OrderHistoryWebReqBeans;
import com.citibank.ohs.web.beans.OrderHistoryWebResBeans;
import com.citibank.ohs.web.beans.Orders;

@Controller
public class OrderHistoryWebController {

	@RequestMapping(value = "/orderrequest", method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		return new ModelAndView("request", "webReq", new OrderHistoryWebReqBeans());
	}

	@RequestMapping(value = "/getorders", method = RequestMethod.POST)
	public String getOrderHistory(@ModelAttribute("webReq") OrderHistoryWebReqBeans webReq, Model model,
			HttpServletRequest request) {
		String page = "success";
		try {
			// get the webrequest from user
			// prepare the webservice request for client
			OrderHistoryWebSvcReq webSvcReq = new OrderHistoryWebSvcReq();
			CardDetails cd = new CardDetails();
			cd.setCardNumber(webReq.getCardNumber());
			System.out.println("cardnum" + webReq.getCardNumber());
			cd.setCvvNum(webReq.getCvvNum());
			cd.setExpDate(webReq.getExpDate());
			cd.setNameOnCard(webReq.getNameOnCard());

			DateRange dd = new DateRange();
			dd.setStartDate(webReq.getStartDate());
			System.out.println("satrtdate=" + webReq.getStartDate());
			dd.setEndDate(webReq.getEndDate());

			OrdersInfo ii = new OrdersInfo();
			ii.setPrice(Double.valueOf(webReq.getPrice()));
			ii.setTypeOfOrder(webReq.getTypeOfOrder());

			ServiceDetails sd = new ServiceDetails();
			sd.setApiName("orderhistory");
			sd.setServiceName("amazon");
			sd.setVersion("34456666");

			webSvcReq.setServiceDetails(sd);
			webSvcReq.setCardDetails(cd);
			webSvcReq.setOrdersInfo(ii);
			webSvcReq.setDateRange(dd);
			// create the webservice client object
			System.out.println(webReq);

			OrderHistoryServiceClient svcClient = new OrderHistoryServiceClientImpl();
			// call the websvc client by passing wsreq object and get the wsresp

			OrderHistoryWebSvcRes webResp = svcClient.getOrderHistory(webSvcReq);
			// store the webResp into session or request scope
			if (webResp.getOrderHistoryDetails() != null) {
				List<OrderHistory> orderList = webResp.getOrderHistory();

				List<Orders> respOrderList = new ArrayList<Orders>();

				OrderHistoryWebResBeans webRes = null;

				for (OrderHistory orderHistory : orderList) {

					Orders order = new Orders();

					order.setOid(Integer.valueOf(orderHistory.getOid()));
					order.setDate(orderHistory.getDate());
					order.setDesc(orderHistory.getDesc());
					order.setName(orderHistory.getName());
					order.setPrice(Integer.valueOf(orderHistory.getPrice()));
					order.setType(orderHistory.getType());
					order.setStatus(orderHistory.getStatus());
					respOrderList.add(order);
					Collections.sort(respOrderList,
							(e1, e2) -> (e1.getOid() < e2.getOid()) ? -1 : (e1.getOid() > e2.getOid()) ? 1 : 0);

					webRes = new OrderHistoryWebResBeans();
					webRes.setOrders(respOrderList);
				}
				model.addAttribute("listOrder", respOrderList);
				HttpSession session = request.getSession();
				session.setAttribute("weblistDownloader", respOrderList);

			} else {
				OrderHistoryWebResBeans webRes = new OrderHistoryWebResBeans();
				StatusBlock sb = webResp.getStatusBlock();
				StatusBlock sw = new StatusBlock();
				sw.setRespCode(sb.getRespCode());
				sw.setRespMessage(sb.getRespMessage());
				webRes.setStatusBlockWeb(sw);
				model.addAttribute("webRespStatus", sw);

				return "failure";
			}
		} catch (Exception e) {

			page = "failure";
			e.printStackTrace();
		}
		return page;

		/*
		 * @PostMapping(value = "/getOrders")
		 * 
		 * // public ModelAndView getOrderHistory(OrderHistoryWebReqBeans webReq) {
		 * public String getOrderHistory(Model model, @ModelAttribute("orderCmd")
		 * OrderCmd cmd,OrderHistoryWebReqBeans webReq) {
		 * 
		 * String page = "sucess";
		 * 
		 * try { // get the webRequest from user // prepare the werService request for
		 * client OrderHistoryWebSvcReq svcReq = new OrderHistoryWebSvcReq();
		 * 
		 * CardDetails cardDetails = new CardDetails();
		 * cardDetails.setCardNumber(webReq.getCardNumber());
		 * cardDetails.setCvvNum(webReq.getCvvNum());
		 * cardDetails.setExpDate(webReq.getExpDate());
		 * cardDetails.setNameOnCard(webReq.getNameOnCard());
		 * 
		 * DateRange dateRange = new DateRange();
		 * dateRange.setEndDate(webReq.getEndDate());
		 * dateRange.setStartDate(webReq.getStartDate());
		 * 
		 * OrdersInfo ordersInfo = new OrdersInfo();
		 * ordersInfo.setPrice(Double.valueOf(webReq.getPrice()));
		 * ordersInfo.setTypeOfOrder(webReq.getTypeOfOrder());
		 * 
		 * svcReq.setCardDetails(cardDetails); svcReq.setDateRange(dateRange);
		 * svcReq.setOrdersInfo(ordersInfo);
		 * 
		 * // create the webService client obj OrderHistoryServiceClient svcClient = new
		 * OrderHistoryServiceClientImpl(); // call the webService client by passing
		 * wsReq obj and get the wsresp OrderHistoryWebSvcRes wsResp =
		 * svcClient.getOrderHistory(svcReq); // convert the wsResp to webResp
		 * OrderHistoryWebResBeans webResp = new OrderHistoryWebResBeans();
		 * 
		 * List<Orders> ordersList=new ArrayList<Orders>(); Orders order=new Orders();
		 * order.setDate(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getDate());
		 * order.setDesc(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getDesc());
		 * order.setName(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getName());
		 * order.setOid(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).getOid(
		 * )); order.setPrice(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getPrice());
		 * order.setStatus(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getStatus());
		 * order.setType(wsResp.getOrderHistoryDetails().getOrderHistory().get(0).
		 * getType()); ordersList.add(order);
		 * 
		 * webResp.setOrders(ordersList);
		 * webResp.setRespCode(wsResp.getStatusBlock().getRespCode());
		 * webResp.setRespmsg(wsResp.getStatusBlock().getRespMessage()); // store the
		 * webResp into sessions or request scope model.addAttribute("result", webResp);
		 * } catch (Exception e) { page = "failure"; e.printStackTrace(); }
		 * 
		 * return page; }
		 */
	}
}