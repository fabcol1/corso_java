
var buf = {};

function bitcoinLastMonth() {
	// PRENDO I DATI DAL MIO DB
	getBitcoinJSON();
}

function getBitcoinJSON() {

	console.log("chiamata funzione getBitcoinJSON()");

	var myRequest = new XMLHttpRequest();

	myRequest.open('POST', '/CryptocurrencyWeb/GetBitcoinLastMonth');

	myRequest.onreadystatechange = function() {
		var res;
		if (myRequest.readyState === 4) {
			console.log("responseText: " + myRequest.responseText);
			res = JSON.parse(myRequest.responseText);
			console.log("res: " + res);

			initChart(res);
		}
	};

	myRequest.send();
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
	
	
	drawChart();
}

function drawChart() {
	var id = 'Bitcoin LASTM';
	var ctx = document.getElementById(id).getContext('2d');
	var chart = new Chart(ctx, {
		type : 'line',
		data : {
			datasets : [ {
				data : buf['Bitcoin'],
				label : 'Valore', // 'buy' price data
				borderColor : 'rgb(255, 99, 132)', // line color
				backgroundColor : 'rgba(255, 99, 132, 0.5)', // fill color
				fill : false, // no fill
				lineTension : 0
			// straight line
			} ]
		},
		options : {
			title : {
				text : 'BTC/USD (' + id + ')', // chart title
				display : true
			}, 
			scales: {
			    xAxes: [{
			      type: "time",
			      time: {
			        unit: 'hour',
			        unitStepSize: 1,
			        round: 'hour',
			        tooltipFormat: "h:mm:ss a",
			        displayFormats: {
			          hour: 'MMM D, h:mm A'
			        }
			      }
			    }],
			    yAxes: [{
			      gridLines: {
			        color: "black",
			        borderDash: [2, 5],
			      }
			    }]
			  }
		}
	});
}