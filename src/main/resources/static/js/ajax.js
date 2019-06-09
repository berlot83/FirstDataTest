/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

function getCardInformation(){
	$('#console').empty();
	var console = document.getElementById("console");
	var	nameCard = document.querySelector('input[name="creditCard"]:checked').value;
	var xhr = new XMLHttpRequest();
	var url = "/card/info/" + nameCard;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = JSON.stringify(JSON.parse(data), null, 2);
			console.append(json);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function getAllCardInformation(){
	$('#console').empty();
	var console = document.getElementById("console");
	var xhr = new XMLHttpRequest();
	var url = "/card";
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = JSON.stringify(JSON.parse(data), null, 2);
			console.append(json);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();	
}

function getRates(){
	$('#console').empty();
	var console = document.getElementById("console");
	var	nameCard = document.querySelector('input[name="creditCard"]:checked').value;
	var xhr = new XMLHttpRequest();
	var url = "/card/rate/" + nameCard ;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = JSON.stringify(JSON.parse(data), null, 2);
			switch(nameCard){
			case "PERE":
				console.append("Operation Rates for PERE = " + json);
				break;
			case "SCO":
				console.append("Operation Rates for SCO = " + json);
				break;
			case "SQUA":
				console.append("Operation Rates for SQUA = " + json);
				break;
			}
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function getCardName(){
	$('#console').empty();
	var	nameCard = document.querySelector('input[name="creditCard"]:checked').value;
	var console = document.getElementById("console");
	var xhr = new XMLHttpRequest();
	var url = "/card/name/" + nameCard;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			console.append(data);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();	
}

function buyItem(){
	$('#console').empty();
	var consoleView = document.getElementById("console");
	var	nameCard = document.querySelector('input[name="creditCard"]:checked').value;
	var totalAmount = document.getElementById("totalAmount").value;
	var date = document.getElementById("date").value;
	var xhr = new XMLHttpRequest();
	var url = "/card/charge";
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			consoleView.append("OK 200, Charge Accepted");
		}else if(xhr.readyState == 4 && xhr.status == 400){
			consoleView.append("Please check amount lower than 1000 and date before from the expiry of the card");
		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("totalAmount=" + totalAmount + "&date=" + date + "&creditCard=" + nameCard);	
}

function checkCard(){
	$('#console').empty();
	var consoleView = document.getElementById("console");
	var	cardNumber = document.getElementById("creditNumber").value;
	var xhr = new XMLHttpRequest();
	var url = "/card/validate";
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			consoleView.style.color = "green";
			consoleView.append(xhr.responseText);
		}else if(xhr.readyState == 4 && xhr.status == 404){
			consoleView.style.color = "red";
			consoleView.append(xhr.responseText);
		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("cardNumber=" + cardNumber);	
}