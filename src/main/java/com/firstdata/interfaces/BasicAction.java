package com.firstdata.interfaces;
import java.time.LocalDate;

import com.firstdata.model.CreditCard;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public interface BasicAction<T extends CreditCard> {

	T retirveCardInformation(T card);
	
	boolean checkExpirationDate(T card, LocalDate dateOfCharge);
	
	String identifyCreditCard(String card) throws Exception;
	
	double retriveActiveRates(T card) throws Exception;

	boolean validAmount(double money);
}
