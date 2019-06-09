package com.firstdata.config;
import java.math.BigInteger;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.firstdata.implementations.CreditCardImplementations;
import com.firstdata.implementations.OnChargeImplementations;
import com.firstdata.model.PERE;
import com.firstdata.model.SCO;
import com.firstdata.model.SQUA;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

@Configuration
public class ContextConfig {

	@Bean(name = "PERE")
	public PERE pere() {
		PERE pere = new PERE();
		pere.setBrandName("PERE");
		pere.setCardHolder("12345678912");
		pere.setCardNumber(new BigInteger("1234561234567812"));
		pere.setExpiration(LocalDate.of(2020, 10, 1));
		return pere;
	}

	@Bean(name = "SCO")
	public SCO sco() {
		SCO sco = new SCO();
		sco.setBrandName("SCO");
		sco.setCardHolder("32165498798");
		sco.setCardNumber(new BigInteger("258963214569"));
		sco.setExpiration(LocalDate.of(2025, 9, 1));
		return sco;
	}

	@Bean(name = "SQUA")
	public SQUA squa() {
		SQUA squa = new SQUA();
		squa.setBrandName("SQUA");
		squa.setCardHolder("789456789654");
		squa.setCardNumber(new BigInteger("321654987563"));
		squa.setExpiration(LocalDate.of(2030, 11, 1));
		return squa;
	}

	@Bean
	public CreditCardImplementations creditCardImplementations() {
		return new CreditCardImplementations();
	}
	
	@Bean
	public OnChargeImplementations onChargeImplementations() {
		return new OnChargeImplementations();
	}
}
