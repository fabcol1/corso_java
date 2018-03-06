
function initBTCRealTimeChart() {
	var midN = new Date();
	midN.setHours(0, 0, 0, 0);
console.log(midN);
	
	var d = new Date();	
console.log(d);

	var diff = d.getTime() - midN.getTime();
console.log(diff);

	var id = 'Bitcoin';
	var ctx = document.getElementById(id).getContext('2d');
	var chart = new Chart(ctx, {
		type : 'line',
		data : {
			datasets : [ {
				data : [],
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
			scales : {
				xAxes : [ {
					type : 'realtime'// auto-scroll on X axis
				} ]
			},
			plugins : {
				streaming : {
					duration : diff, // display data for the latest 300000ms (5 mins)
					onRefresh : function(chart) { // callback on chart update interval
console.log("buf: " + buf[id]);
						Array.prototype.push.apply(chart.data.datasets[0].data,
								buf[id]); // add 'buy' price data to chart
						// add 'sell' price data to chart
						buf[id] = []; // clear buffer
					}
				}
			}
		}
	});
}
