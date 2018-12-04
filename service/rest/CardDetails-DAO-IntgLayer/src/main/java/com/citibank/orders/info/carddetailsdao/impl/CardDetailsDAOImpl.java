package com.citibank.orders.info.carddetailsdao.impl;

import java.util.ArrayList;
import java.util.List;

import com.citibank.orders.info.carddetailsdao.CardDetailsDAO;
import com.citibank.orders.info.carddetailsdao.beans.CardResponse;

public class CardDetailsDAOImpl implements CardDetailsDAO {

	public CardResponse getAllCards(String cardNum) {

		// 1.get the request from the PL

		// 2. prepare the request for DB

		// 3. invoke the DB get the resultset

		// 4. prepare the CardResponse

		CardResponse cardDAOResponse = new CardResponse();
		List<String> cardList = new ArrayList<String>();
		cardList.add("000152458931678");
		cardList.add("000789458938630");
		cardList.add("000754839392626");

		cardDAOResponse.setRespCode("0");
		cardDAOResponse.setRespMessage("Success");
		cardDAOResponse.setCardList(cardList);

		return cardDAOResponse;
	}

}
