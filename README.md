/* Author Axel Berlot, berlot83@yahoo.com.ar, 2019/06/09, First Data test */

Technologies:
Spring-boot, Thymeleaf, Jquery.

Maven dependencies:
Spring-boot-web-starter dependency
Spring-boot-starter-thymeleaf dependency

/* List of Rest methods ==> Params ==> return type*/

Methods:

getAllCreditCards()
GET ==> /card ==> return List<CreditCard>.

retriveNameCard()
GET ==> /card/name/{nameCard} ==> @PathVariable String ==> return String.

getCardInformation()
GET ==> /card/info/{nameCard} ==> @PathVariable String ==> return String.

compareCards()	/* Not implemented into the GUI of  Heroku for simplicity */
POST ==> /card/compare ==> @ModelAttribute CreditCard, @ModelAttribute CreditCard ==> return boolean.

getRates()
GET ==> /card/rate/{card} ==> @PathVariable String ==> return double.

validateCard()
POST ==> /card/validate ==> @RequestParam String ==> return ResponseEntity<String>.

chargeControl()
POST ==> /card/charge ==> @RequestParam double, @RequestParam String, @RequestParam CreditCard ==> Return ResponseEntity<String>.