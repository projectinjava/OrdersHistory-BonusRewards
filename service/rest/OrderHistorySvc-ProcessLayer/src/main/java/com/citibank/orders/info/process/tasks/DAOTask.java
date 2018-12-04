package com.citibank.orders.info.process.tasks;

import java.util.concurrent.Callable;

import com.citibank.orders.info.dao.OrderHistoryDAO;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOResBean;
import com.citibank.orders.info.dao.impl.OrderHistoryDAOImpl;

public class DAOTask implements Callable<OrderHistoryDAOResBean> {
	
	OrderHistoryDAOReqBean daoReq;
	
	public DAOTask(OrderHistoryDAOReqBean daoReq) {
		this.daoReq=daoReq;	
	}

	public OrderHistoryDAOResBean call() throws Exception {
		
		OrderHistoryDAOResBean daoResponse = new OrderHistoryDAOResBean();
		
		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();
		 daoResponse =  orderHistoryDAO.getOrderHistory(daoReq);
		 
		 System.out.println("daoresponse from DAOTASK"+daoResponse);
			
		return daoResponse;
	}

}
