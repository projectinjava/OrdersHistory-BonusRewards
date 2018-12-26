package com.citibank.orders.info.service.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.citibank.orders.info.dao.exce.BusinessException;
import com.citibank.orders.info.process.beans.OrderDetailsProcessBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessResBean;
import com.citibank.orders.info.service.beans.OrderHistory;
import com.citibank.orders.info.service.beans.OrderHistoryDetails;
import com.citibank.orders.info.service.beans.OrderHistoryServiceReqBean;
import com.citibank.orders.info.service.beans.OrderHistoryServiceResBean;
import com.citibank.orders.info.service.beans.StatusBlock;
import com.citibank.orders.info.service.util.OrderHistoryServiceDateCaluclation;

public class OrderHistoryServiceResBuilder {

	public OrderHistoryServiceResBean buildServiceResponse(OrderHistoryProcessResBean processResp, OrderHistoryServiceReqBean svcReq) throws BusinessException {

		OrderHistoryServiceResBean serviceResp = new OrderHistoryServiceResBean();

		// 6. prepare the service layer response

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(processResp.getRespCode());
		statusBlock.setRespMessage(processResp.getRespMesssage());

		OrderHistoryDetails orderDetails = new OrderHistoryDetails();
		List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();

		List<OrderDetailsProcessBean> processOrderList = processResp.getOrderDetailsProcessBean();

		if (processOrderList == null) {

			return serviceResp;
		}
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringstartDate = svcReq.getDateRange().getStartDate();
		System.out.println(stringstartDate);
		String stringendDate = svcReq.getDateRange().getEndDate();
		try {
			startDate = sdf.parse(stringstartDate);
			System.out.println(startDate);
			endDate = sdf.parse(stringendDate);
			System.out.println(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long days = OrderHistoryServiceDateCaluclation.daysBetween(startDate, endDate);
		System.out.println("total=" + days);
		if (days <= 364) {
			for (OrderDetailsProcessBean orderDtls : processOrderList) {
				String orderStringDate = orderDtls.getDate();

				System.out.println(orderStringDate);
				Date transDate = null;
				try {
					transDate = sdf.parse(orderStringDate);
					System.out.println("asdasdasdsad" + transDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// sorting
				/*
				 * if (startDate.getTime() >= transDate.getTime() && transDate.getTime() >=
				 * endDate.getTime()) { System.out.println("1"); System.out.println(
				 * startDate.getTime() >= transDate.getTime() && transDate.getTime() >=
				 * endDate.getTime()); OrderHistory orderHistory = new OrderHistory();
				 * orderHistory.setOid(orderDtls1.getOid());
				 * orderHistory.setName(orderDtls1.getName());
				 * orderHistory.setDesc(orderDtls1.getDesc());
				 * orderHistory.setStatus(orderDtls1.getStatus());
				 * orderHistory.setType(orderDtls1.getType());
				 * orderHistory.setPrice(orderDtls1.getPrice());
				 * orderHistory.setCardnumber(orderDtls1.getCardnumber());
				 * orderHistory.setDate(orderDtls1.getDate());
				 * orderHistoryList.add(orderHistory); }
				 */

				// for sorting
				if (endDate.after(transDate) && startDate.before(transDate) || startDate.equals(transDate)
						|| endDate.equals(transDate)) {
					System.out.println("time =" + endDate.after(transDate));
					System.out.println("date sorting and default sorting");
					
					OrderHistory orderHistory = new OrderHistory();
					orderHistory.setOid(orderDtls.getOid());
					orderHistory.setName(orderDtls.getName());
					orderHistory.setDesc(orderDtls.getDesc());
					orderHistory.setStatus(orderDtls.getStatus());
					orderHistory.setType(orderDtls.getType());
					orderHistory.setPrice(orderDtls.getPrice());
					orderHistory.setCardnumber(orderDtls.getCardNumber());
					orderHistory.setDate(orderDtls.getDate());
					
					orderHistoryList.add(orderHistory);
				}

				serviceResp.setStatusBlock(statusBlock);
				serviceResp.setOrderHistory(orderHistoryList);
				
				System.out.println("exit from response buildr");

			}
			//System.out.println("ordehistory" + svcRserviceRespesp.getOrderHistory());
			if (serviceResp.getOrderHistory().isEmpty()) {
				System.out.println("else block");
				StatusBlock sb = new StatusBlock();
				sb.setRespCode("109");
				sb.setRespMessage("please provide valid date");
				System.out.println(sb);
				serviceResp.setStatusBlock(sb);
				throw new BusinessException(sb.getRespCode(), sb.getRespMessage());
			}

		}
		return serviceResp;
	}
}
/*
 * for (OrderDetailsProcessBean orderDetailsProcessBean : processOrderList) {
 * 
 * OrderHistory orderHistory = new OrderHistory();
 * orderHistory.setOid(orderDetailsProcessBean.getOid());
 * orderHistory.setName(orderDetailsProcessBean.getName());
 * orderHistory.setDesc(orderDetailsProcessBean.getDesc());
 * orderHistory.setDate(orderDetailsProcessBean.getDate());
 * orderHistory.setPrice(orderDetailsProcessBean.getPrice());
 * orderHistory.setStatus(orderDetailsProcessBean.getStatus());
 * orderHistory.setType(orderDetailsProcessBean.getType());
 * 
 * orderHistoryList.add(orderHistory);
 * 
 * } orderDetails.setOrderHistory(orderHistoryList);
 * 
 * // 7. set the serviceResp using processResp
 * 
 * serviceResp.setStatusBlock(statusBlock);
 * serviceResp.setOrderHistoryDetails(orderDetails);
 * 
 * return serviceResp; }
 * 
 * }
 */