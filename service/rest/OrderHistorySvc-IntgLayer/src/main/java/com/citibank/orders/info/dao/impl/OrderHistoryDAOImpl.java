package com.citibank.orders.info.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.citibank.orders.info.dao.OrderHistoryDAO;
import com.citibank.orders.info.dao.beans.OrderDetailsDAO;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOResBean;
import com.citibank.orders.info.dao.exce.BusinessException;
import com.citibank.orders.info.dao.exce.SystemException;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	private static final String ORDER_HISTORY = "{call GETOrderHistory(?,?,?,?,?)}";

	public OrderHistoryDAOResBean getOrderHistory(OrderHistoryDAOReqBean daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {

		System.out.println("entered into orderhistory dao layer " + daoReq);
		// 1. get the request from PL
		// 2. prepare the request for DB
		// 3. call the DB and get the Resultset
		// 4. prepare the response- daoResponse

		CallableStatement cal = null;
		ResultSet rs = null;
		int resultSetCount = 0;
		OrderHistoryDAOResBean daoResponse = null;

		List<OrderDetailsDAO> orderDetailsList = new ArrayList<OrderDetailsDAO>();

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/orderhistory?autoReconnect=true&useSSL=false", "root", "root");
		cal = connection.prepareCall(ORDER_HISTORY);

		// Date d1=new SimpleDateFormat("dd/mm/yyyy").parse(daoReq.getStartDate());

		// Date d2=new SimpleDateFormat("dd/mm/yyyy").parse(daoReq.getEndDate());
		cal.registerOutParameter(4, Types.VARCHAR);
		cal.registerOutParameter(5, Types.VARCHAR);
		cal.setString(1, daoReq.getClientId());
		cal.setString(2, daoReq.getChannelId());
		cal.setString(3, daoReq.getCardNumber());

		cal.execute();
		resultSetCount = cal.getUpdateCount();
		rs = cal.executeQuery();

		try {
			daoResponse = new OrderHistoryDAOResBean();

			if ((rs != null)) {
				System.out.println("enter into result set");
				if ("0".equals(daoResponse.getRespCode())) {

					while (rs.next()) {

						OrderDetailsDAO orderDtls = new OrderDetailsDAO();

						orderDtls.setOid(rs.getString(2));
						orderDtls.setName(rs.getString(3));
						orderDtls.setDesc(rs.getString(4));
						orderDtls.setStatus(rs.getString(5));
						orderDtls.setType(rs.getString(6));
						orderDtls.setPrice(rs.getString(7));
						orderDtls.setCardnumber(rs.getString(8));
						orderDtls.setDate(rs.getString(9));

						orderDetailsList.add(orderDtls);

						daoResponse.setRespCode(cal.getString(4));
						daoResponse.setRespMesssage(cal.getString(5));
						daoResponse.setOrderDetails(orderDetailsList);

						System.out.println("Order service intg layer :" + daoResponse);
					}

				} else {
					if ("100".equals(daoResponse.getRespCode()) || "101".equals(daoResponse.getRespCode()) || "103".equals(daoResponse.getRespCode())) {
						throw new BusinessException(daoResponse.getRespCode(), daoResponse.getRespMesssage());
					} else {
						throw new SystemException(daoResponse.getRespCode(), daoResponse.getRespMesssage());
					}
				}
			}
		} catch (BusinessException be) {
			// be.printStackTrace();
			throw be;
		} catch (SystemException se) {
			// se.printStackTrace();
			throw se;
		}
		System.out.println("exit from service intg :"+daoResponse);
		return daoResponse;
	}
}
/*
 * OrderDetailsDAO orderDetails = new OrderDetailsDAO();
 * orderDetails.setOid("1112"); orderDetails.setName("ac");
 * orderDetails.setDate("11072016"); orderDetails.setDesc("electronic");
 * orderDetails.setPrice("4997"); orderDetails.setStatus("failed");
 * orderDetails.setType("Eletronic Product");
 * 
 * OrderDetailsDAO orderDetails1 = new OrderDetailsDAO();
 * orderDetails1.setOid("1113"); orderDetails1.setName("bat");
 * orderDetails1.setDate("11112018"); orderDetails1.setDesc("sports");
 * orderDetails1.setPrice("2000"); orderDetails1.setStatus("pending");
 * orderDetails1.setType("Eletronic Product");
 * 
 * OrderDetailsDAO orderDetails2 = new OrderDetailsDAO();
 * orderDetails2.setOid("1119"); orderDetails2.setName("tablet");
 * orderDetails2.setDate("18052018"); orderDetails2.setDesc("electronic");
 * orderDetails2.setPrice("10000"); orderDetails2.setStatus("success");
 * orderDetails2.setType("Eletronic Product");
 * 
 * 
 * orderDetailsList.add(orderDetails); orderDetailsList.add(orderDetails1);
 * orderDetailsList.add(orderDetails2);
 * 
 * daoResponse.setRespCode("0"); daoResponse.setRespMesssage("success");
 * daoResponse.setOrderDetails(orderDetailsList); } else { if
 * ("100".equals(dbRespCode) || "101".equals(dbRespCode)) { throw new
 * BusinessException(dbRespCode, dbRespMsg); } else { throw new
 * SystemException(dbRespCode, dbRespMsg); } }
 * 
 * } catch (BusinessException be) { be.printStackTrace(); throw be; } catch
 * (SystemException se) { se.printStackTrace(); throw se; }
 * 
 * System.out.println("exit from orderHistoryDAO " + daoResponse); return
 * daoResponse; }
 */