package com.firstdata.model;
import java.math.BigInteger;
import java.time.LocalDate;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public abstract class CreditCard {

	private String brandName;
	private BigInteger cardNumber;
	private String cardHolder;
	private LocalDate expiration;
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

}
