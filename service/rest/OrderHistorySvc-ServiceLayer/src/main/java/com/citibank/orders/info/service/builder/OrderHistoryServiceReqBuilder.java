package com.citibank.orders.info.service.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;
import com.citibank.orders.info.service.beans.DateRange;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.util.OrderHistoryServiceDateConversion;

public class OrderHistoryServiceReqBuilder {

	public OrderHistoryProcessReqBean buildProcessReq(OrderHistoryServiceReqBean serviceReq) {

		System.out.println("Enter into svc req builder");
		OrderHistoryProcessReqBean processReq = new OrderHistoryProcessReqBean();

		processReq.setClientId(serviceReq.getClientContext().getClientId());
		processReq.setChannelId(serviceReq.getClientContext().getChannelId());
		processReq.setCardNum(serviceReq.getCardDetails().getCardNumber());
		processReq.setCvvNum(serviceReq.getCardDetails().getCvvNum());
		processReq.setNameOnCard(serviceReq.getCardDetails().getNameOnCard());
		processReq.setExpDate(serviceReq.getCardDetails().getExpDate());
		processReq.setRequestId(serviceReq.getClientContext().getRequestId());

		if (serviceReq.getDateRange().getStartDate().trim() == null
				|| "".equals(serviceReq.getDateRange().getStartDate())
						&& serviceReq.getDateRange().getEndDate().trim() == null
				|| "".equals(serviceReq.getDateRange().getEndDate())) {
			String startDate = null; // last 60 days
			String endDate = null; // current date

			OrderHistoryServiceDateConversion dc = new OrderHistoryServiceDateConversion();
			// last 60 days date

			LocalDate d = dc.dateCon();
			// current date
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			startDate = formatter.format(d);// last 60 days
			System.out.println("last 60 days=" + startDate);
			endDate = formatter.format(now);// current date
			System.out.println("current=" + endDate);
			DateRange dd = new DateRange();
			dd.setStartDate(startDate);
			dd.setEndDate(endDate);
			serviceReq.setDateRange(dd);

			processReq.setStartDate(startDate);
			processReq.setEndDate(endDate);
		} else {
			processReq.setStartDate(serviceReq.getDateRange().getStartDate());
			processReq.setEndDate(serviceReq.getDateRange().getEndDate());
		}
		processReq.setExpDate(serviceReq.getCardDetails().getExpDate());
		processReq.setTypeOfOrder(serviceReq.getOrdersInfo().getTypeOfOrder());
		processReq.setPrice(Double.valueOf(serviceReq.getOrdersInfo().getPrice()));

		System.out.println("exit fro svc req builder");
		return processReq;
	}

}