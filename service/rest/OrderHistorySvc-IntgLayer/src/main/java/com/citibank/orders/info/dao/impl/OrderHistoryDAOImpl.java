package com.citibank.orders.info.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.citibank.orders.info.dao.OrderHistoryDAO;
import com.citibank.orders.info.dao.beans.OrderDetailsDAO;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOResBean;
import com.citibank.orders.info.dao.exce.BusinessException;
import com.citibank.orders.info.dao.exce.SystemException;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	public OrderHistoryDAOResBean getOrderHistory(OrderHistoryDAOReqBean daoReq)
			throws BusinessException, SystemException {

		System.out.println("entered into orderhistory dao layer " + daoReq);
		// 1. get the request from PL
		// 2. prepare the request for DB
		// 3. call the DB and get the Resultset
		// 4. prepare the response- daoResponse

		OrderHistoryDAOResBean daoResponse = null;
		try {
			String dbRespCode = "0";
			String dbRespMsg = "Sucess";

			if ("0".equals(dbRespCode)) {
				daoResponse = new OrderHistoryDAOResBean();

				List<OrderDetailsDAO> orderDetailsList = new ArrayList<OrderDetailsDAO>();

				OrderDetailsDAO orderDetails = new OrderDetailsDAO();
				orderDetails.setOid("1112");
				orderDetails.setName("ac");
				orderDetails.setDate("11072016");
				orderDetails.setDesc("electronic");
				orderDetails.setPrice("4997");
				orderDetails.setStatus("failed");
				orderDetails.setType("Eletronic Product");

				OrderDetailsDAO orderDetails1 = new OrderDetailsDAO();
				orderDetails1.setOid("1113");
				orderDetails1.setName("bat");
				orderDetails1.setDate("11112018");
				orderDetails1.setDesc("sports");
				orderDetails1.setPrice("2000");
				orderDetails1.setStatus("pending");
				orderDetails1.setType("Eletronic Product");

				OrderDetailsDAO orderDetails2 = new OrderDetailsDAO();
				orderDetails2.setOid("1119");
				orderDetails2.setName("tablet");
				orderDetails2.setDate("18052018");
				orderDetails2.setDesc("electronic");
				orderDetails2.setPrice("10000");
				orderDetails2.setStatus("success");
				orderDetails2.setType("Eletronic Product");
				

				orderDetailsList.add(orderDetails);
				orderDetailsList.add(orderDetails1);
				orderDetailsList.add(orderDetails2);

				daoResponse.setRespCode("0");
				daoResponse.setRespMesssage("success");
				daoResponse.setOrderDetails(orderDetailsList);
			} else {
				if ("100".equals(dbRespCode) || "101".equals(dbRespCode)) {
					throw new BusinessException(dbRespCode, dbRespMsg);
				} else {
					throw new SystemException(dbRespCode, dbRespMsg);
				}
			}

		} catch (BusinessException be) {
			be.printStackTrace();
			throw be;
		} catch (SystemException se) {
			se.printStackTrace();
			throw se;
		}

		System.out.println("exit from orderHistoryDAO " + daoResponse);
		return daoResponse;
	}
}