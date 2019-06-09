package com.firstdata.implementations;

import com.firstdata.interfaces.OnCharge;
import com.firstdata.model.CreditCard;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public class OnChargeImplementations implements OnCharge<CreditCard>{

	@Override
	public void imprimirFactura(CreditCard card) {
	}

	@Override
	public void enviarInfoTC(CreditCard card) {
	}

	@Override
	public void informarPago(CreditCard card) {
	}

	@Override
	public void actualizarSaldo(CreditCard card) {
	}

}
