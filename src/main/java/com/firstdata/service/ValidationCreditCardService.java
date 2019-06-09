package com.firstdata.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.GenericWebApplicationContext;
import com.firstdata.implementations.CreditCardImplementations;
import com.firstdata.implementations.OnChargeImplementations;
import com.firstdata.model.Charge;
import com.firstdata.model.CreditCard;
import com.firstdata.model.SCO;
import com.firstdata.model.SQUA;
import com.firstdata.utilities.Utilities;
import com.firstdata.utilities.ValidationCreditCard;
import com.firstdata.model.PERE;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

@RestController
public class ValidationCreditCardService {

	final static Logger logger = Logger.getLogger(ValidationCreditCardService.class);
	
	@Autowired
	GenericWebApplicationContext context;
	
	@Autowired
	CreditCardImplementations creditCardImplementations;
	
	@Autowired
	OnChargeImplementations onChargeImplementations;
	
	/* retrive credit card name by name */
	@GetMapping(value = "/card/name/{nameCard}")
	public String retriveNameCard(@PathVariable(value = "nameCard") String card) throws Exception {
		if(card != null) {
			logger.debug("Works");
			return creditCardImplementations.identifyCreditCard(card);
		}else {
			throw new Exception("No card is available with this name");
		}
	}
	
	/* Retrive all data Card */
	@GetMapping(value = "/card/info/{nameCard}")
	public CreditCard getCardInformation(@PathVariable(value = "nameCard") String card) throws Exception{
		if(card != null) {
			CreditCard cd = (CreditCard) this.context.getBean(card);
			logger.info("All info about " + card);
			return cd;
		}else {
			logger.error("This card is not available on the system");
			throw new Exception("Type of card not registered on the system");
		}
	}
	
	/* Calculate the rate from different cards */
	@GetMapping(value = "/card/rate/{card}")
	public double calulateRate(@PathVariable("card") String card) throws Exception {
		CreditCard cd = null;
		switch(card) {
		case "SCO":
			cd = (SCO) this.context.getBean("SCO");
			return creditCardImplementations.retriveActiveRates(cd);
		case "SQUA":
			cd = (SQUA) this.context.getBean("SQUA");
			return creditCardImplementations.retriveActiveRates(cd);
		case "PERE":
			cd = (PERE) this.context.getBean("PERE");
			return creditCardImplementations.retriveActiveRates(cd);
		default:
			return 0;
		}
	}
	
	/* Retrive all credit card available */
	@GetMapping(value = "/card")
	public List<CreditCard> getAllCreditCards(){
	
	List<CreditCard> list = new ArrayList<>();
	/* Search all the beans od the type CreditCard */
	Set<String> beans = context.getBeansOfType(CreditCard.class).keySet();
		for (String item : beans) {
			if(item.equals("SCO")) {
				CreditCard	cd = (SCO) this.context.getBean("SCO");
				list.add(cd);
			}else if(item.equals("PERE")) {
				CreditCard	cd = (PERE) this.context.getBean("PERE");
				list.add(cd);
			}else if(item.equals("SQUA")) {
				CreditCard	cd = (SQUA) this.context.getBean("SQUA");
				list.add(cd);
			}
		}
		logger.info("All the cards available on the system");
		return list;
	}
	
	@PostMapping("/card/validate")
	public @ResponseBody ResponseEntity<String> validateCard(@RequestParam(value = "cardNumber") String cardNumber){
		if(ValidationCreditCard.validationNumber(cardNumber)) {
			return new ResponseEntity<String>("Valid Card", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Invalid Card", HttpStatus.NOT_FOUND);
		}
	}
	
	/* Dependency with checkExpirationDate() && validAmount() */
	@PostMapping(value = "/card/charge")
	public @ResponseBody ResponseEntity<String> chargeControl(@RequestParam(value = "totalAmount") double totalAmount, @RequestParam(value = "date") String date, @RequestParam(value = "creditCard") String creditCard) throws Exception {
		CreditCard cd = this.nameToInstanceCreditCard(creditCard);
		Charge charge = new Charge(totalAmount, Utilities.fromDateToLocalDate(date));
		if(totalAmount >= 0 || date == null) {
			
		}else {
			throw new Exception("Date or Total amount are invalid or incomplete.");
		}
		
		if(creditCardImplementations.checkExpirationDate(cd, charge.getDate()) && creditCardImplementations.checkNotBeforeDate(charge.getDate())) {
			if(creditCardImplementations.validAmount(charge.getTotalAmount())) {
				onChargeImplementations.imprimirFactura(cd);
				onChargeImplementations.enviarInfoTC(cd);
				onChargeImplementations.informarPago(cd);
				onChargeImplementations.actualizarSaldo(cd);
				logger.info("Charge accepted");
				return new ResponseEntity<String>("Charges accepted", HttpStatus.OK);
			}else {
				logger.error("Amount is not valid");
				return new ResponseEntity<String>("No Valid amount", HttpStatus.BAD_REQUEST);
			}
		}else {
			logger.error("The date is not valid");
			return new ResponseEntity<String>("No Valid Date", HttpStatus.BAD_REQUEST);
		}
	}
	
	public CreditCard nameToInstanceCreditCard(String card) throws Exception {
		CreditCard cd = null;
		switch(card) {
		case "SCO":
			return cd = (SCO) this.context.getBean("SCO");
		case "SQUA":
			return cd = (SQUA) this.context.getBean("SQUA");
		case "PERE":
			return cd = (PERE) this.context.getBean("PERE");
		default:
			throw new Exception("No credit card with this name is available");
		}
	}
}
