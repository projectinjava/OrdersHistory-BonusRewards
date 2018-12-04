package com.citibank.orders.info.carddetailsdao;

import com.citibank.orders.info.carddetailsdao.beans.CardResponse;

public interface CardDetailsDAO {

	CardResponse getAllCards(String cardNum);

}
