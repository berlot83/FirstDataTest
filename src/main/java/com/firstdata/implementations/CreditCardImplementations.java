package com.firstdata.implementations;
import java.time.LocalDate;
import com.firstdata.interfaces.BasicAction;
import com.firstdata.model.CreditCard;
import com.firstdata.model.PERE;
import com.firstdata.model.SCO;
import com.firstdata.model.SQUA;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public class CreditCardImplementations implements BasicAction<CreditCard> {

	@Override
	public CreditCard retirveCardInformation(CreditCard card) {
		return card;
	}

	@Override
	public String identifyCreditCard(String card) throws Exception {
		String identity = null;
		if(SQUA.class.getSimpleName().equals(card)) {
			identity = SQUA.class.getSimpleName();
		}else if(PERE.class.getSimpleName().equals(card)){
			identity = PERE.class.getSimpleName();
		}else if(SCO.class.getSimpleName().equals(card)) {
			identity = SCO.class.getSimpleName();
		}else {
			throw new Exception("No Card is available with this name");
		}
		return identity;
	}

	@Override
	public double retriveActiveRates(CreditCard card) throws Exception {
		System.out.println(card.getExpiration().getYear());
		System.out.println(card.getExpiration().getMonthValue());
		if (card instanceof SQUA) {
			return (card.getExpiration().getYear() / card.getExpiration().getMonthValue());
		} else if (card instanceof SCO) {
			return (card.getExpiration().getDayOfMonth() * 0.5);
		} else if(card instanceof PERE){
			return (card.getExpiration().getMonthValue() * 0.1);
		}else {
			throw new Exception("No values were found for this card or is not available now");
		}
	}

	@Override
	public boolean validAmount(double money) {
		if(money < 1000) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkExpirationDate(CreditCard card, LocalDate dateOfCharge) {
		LocalDate expirationDate = card.getExpiration();
		if (dateOfCharge.isBefore(expirationDate)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean checkNotBeforeDate(LocalDate dateOfCharge) {
		LocalDate now = LocalDate.now().minusDays(1);
		if (now.isBefore(dateOfCharge)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean compareCards(CreditCard card1, CreditCard card2) throws Exception {
		if(card1.getBrandName().equals(card2.getBrandName()) && card1.getCardNumber().equals(card2.getCardNumber()) && card1.getExpiration().equals(card2.getExpiration())) {
			return true;
		}else{
			return false;
		}
	}
	
}
