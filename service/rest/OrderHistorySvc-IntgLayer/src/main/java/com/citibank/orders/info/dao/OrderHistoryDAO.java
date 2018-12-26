package com.citibank.orders.info.dao;

import java.sql.SQLException;

import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOResBean;
import com.citibank.orders.info.dao.exce.BusinessException;
import com.citibank.orders.info.dao.exce.SystemException;

public interface OrderHistoryDAO {
	OrderHistoryDAOResBean getOrderHistory(OrderHistoryDAOReqBean daoReq) throws BusinessException, SystemException, ClassNotFoundException, SQLException;

}
