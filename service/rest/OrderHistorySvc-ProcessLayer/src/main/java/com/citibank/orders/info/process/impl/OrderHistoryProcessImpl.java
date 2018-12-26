package com.citibank.orders.info.process.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.citibank.orders.info.carddetailsdao.CardDetailsDAO;
import com.citibank.orders.info.carddetailsdao.beans.CardResponse;
import com.citibank.orders.info.carddetailsdao.impl.CardDetailsDAOImpl;
import com.citibank.orders.info.dao.beans.OrderDetailsDAO;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOReqBean;
import com.citibank.orders.info.dao.beans.OrderHistoryDAOResBean;
import com.citibank.orders.info.dao.exce.BusinessException;
import com.citibank.orders.info.dao.exce.SystemException;
import com.citibank.orders.info.process.OrderHistoryProcess;
import com.citibank.orders.info.process.beans.OrderDetailsProcessBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessReqBean;
import com.citibank.orders.info.process.beans.OrderHistoryProcessResBean;
import com.citibank.orders.info.process.tasks.DAOTask;

public class OrderHistoryProcessImpl implements OrderHistoryProcess {

	public OrderHistoryProcessResBean getOrderHistory(OrderHistoryProcessReqBean processReq) throws InterruptedException, ExecutionException, BusinessException, SystemException {
		
		System.out.println("entered into OrderHistoryProcessImpl layer : "+processReq);
		OrderHistoryProcessResBean processResBean = new OrderHistoryProcessResBean();
		// 1. get the request from the service layer
		// 2. prepare the request to 1st Intg layer ie CardDAO and get the reponse by calling the method
		//System.out.println(this.getClass().getSimpleName());

		CardDetailsDAO cardDAO = new CardDetailsDAOImpl();
		
		//call getAllCardsdao
		CardResponse cardRespponse = cardDAO.getAllCards(processReq.getCardNum());
		System.out.println("cardresponse : " + cardRespponse);

		// 3. checking if the cardResponse is valid or not
		// 4 apply paralell call to invoke the orderhistorydao
		try {
			if (cardRespponse!=null && cardRespponse.getCardList() != null && !cardRespponse.getCardList().isEmpty()) {

				Set setOfTask = new HashSet();
				List<String> cardList = cardRespponse.getCardList();

				// setting DAOReqBean
				for (int i = 0; i < cardList.size(); i++) {
					OrderHistoryDAOReqBean daoReq = new OrderHistoryDAOReqBean();
					
					daoReq.setCardNumber(cardRespponse.getCardList().get(i)); //get from cardsResp
					daoReq.setChannelId(processReq.getChannelId());
					daoReq.setClientId(processReq.getClientId());
					daoReq.setStartDate(processReq.getStartDate());
					daoReq.setEndDate(processReq.getEndDate());
					daoReq.setTypeOfOrder(processReq.getTypeOfOrder());
					daoReq.setNameOnCard(processReq.getNameOnCard());
					daoReq.setPrice(processReq.getPrice());
					daoReq.setCvvNum(processReq.getCvvNum());
					daoReq.setExpDate(processReq.getExpDate());
					
					setOfTask.add(new DAOTask(daoReq));
				}

				// executer framework calling preparing the list of task

				ExecutorService executorService = Executors.newFixedThreadPool(cardRespponse.getCardList().size());
				List<Future<OrderHistoryDAOResBean>> ftlist = executorService.invokeAll(setOfTask);

				// getting DAO response and combining all result

				OrderHistoryDAOResBean daoRes = null;
				//get the list of orderhistory from DAOResp and prepare the process response
				List<OrderDetailsProcessBean> orderDetailsProcessBeanList = new ArrayList<OrderDetailsProcessBean>();

				for (Future<OrderHistoryDAOResBean> future : ftlist) {
					try {
						daoRes = future.get();

						System.out.println("in process dao resp:" + daoRes);

					} catch (ExecutionException e) {
						if (e.getCause() instanceof BusinessException) {
							BusinessException be = (BusinessException) e.getCause();
							throw be;

						} else if (e.getCause() instanceof SystemException) {
							SystemException se = (SystemException) e.getCause();
							throw se;
						}
					}
					
					List<OrderDetailsDAO> orderDetailsDAOBeanList = daoRes.getOrderDetails();

					for (OrderDetailsDAO ordersDAO : orderDetailsDAOBeanList) {

						//System.out.println("OrderDetailsDAO "+ordersDAO.getOid());

						OrderDetailsProcessBean orderDetailsProcessBean = new OrderDetailsProcessBean();
						
						orderDetailsProcessBean.setOid(ordersDAO.getOid());
						orderDetailsProcessBean.setName(ordersDAO.getName());
						orderDetailsProcessBean.setDate(ordersDAO.getDate());
						orderDetailsProcessBean.setDesc(ordersDAO.getDesc());
						orderDetailsProcessBean.setPrice(ordersDAO.getPrice());
						orderDetailsProcessBean.setStatus(ordersDAO.getStatus());
						orderDetailsProcessBean.setType(ordersDAO.getType());
						orderDetailsProcessBean.setCardNumber(ordersDAO.getCardnumber());
						
						orderDetailsProcessBeanList.add(orderDetailsProcessBean);
					}
					
					processResBean.setRespCode(daoRes.getRespCode());
					processResBean.setRespMesssage(daoRes.getRespMesssage());
					processResBean.setOrderDetailsProcessBean(orderDetailsProcessBeanList);
				}

			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		//executorService.shutdown();

		System.out.println("Exit from OrderHistoryProcessImpl layer : "+processResBean);
		return processResBean;
	}

}
