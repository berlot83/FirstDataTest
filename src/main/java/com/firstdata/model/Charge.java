package com.firstdata.model;

import java.time.LocalDate;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public class Charge {
	private String description;
	private double totalAmount;
	private LocalDate date;

	public Charge() {

	}

	public Charge(double totalAmount, LocalDate date) {
		this.totalAmount = totalAmount;
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
