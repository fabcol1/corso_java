
var buf = {};

function bitcoinRealTime() {
	initBTCRealTimeChart();

	// PRENDO I DATI DAL MIO DB
	getBitcoinJSON(true);
	setInterval(getBitcoinJSON, (25000));
//		 	getBitcoinJSON();
}

function getBitcoinJSON(firstTime) {

	console.log("chiamata funzione getBitcoinJSON()");

	var myRequest = new XMLHttpRequest();

	myRequest.open('POST', '/CryptocurrencyWeb/GetBitcoin');

	myRequest.onreadystatechange = function() {
		var res;
		if (myRequest.readyState === 4) {
			console.log("responseText: " + myRequest.responseText);
			res = JSON.parse(myRequest.responseText);
			console.log("res: " + res);

			initChart(res);
		}
	};
	console.log(firstTime);
	if (firstTime != null && firstTime) {
		myRequest.send(JSON.stringify({
			message : "first"
		}));
	} else {
		myRequest.send();
	}
}

function initChart(res) {
	console.log(res);
	buf['Bitcoin'] = [];

	for (var i = 0; i < res.length; i++) {

		var bitcoin = res[i];
		console.log(bitcoin);
		var bitcoinDate = bitcoin["dataValore"];
		console.log(bitcoinDate);
		var date = new Date(bitcoinDate);

		console.log((date.getTime() / 1000) + 3600);

		buf['Bitcoin'].push({
			x : ((date.getTime()) + 3600),
			y : bitcoin["cambioValore"]
		});

		console.log(buf);
	}
}
