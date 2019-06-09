package com.firstdata.interfaces;

import com.firstdata.model.CreditCard;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

public interface OnCharge<T extends CreditCard> {

	public void imprimirFactura(T card); // imprimir factura en controladora fiscal

	public void enviarInfoTC(T card); // enviar info de tarjeta de crédito

	public void informarPago(T card); // Informar pago a comercial

	public void actualizarSaldo(T card);

}
