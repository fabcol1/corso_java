app.controller('chartsController', function($scope, $http, $location, $route,
		$log, $q) {
	// HANDLE MULTIPE HTTP REQUEST WITH ANGULARJS
	$q.all([ $http.get('/api/bitcoin/lastDay'),
			 $http.get('/api/litecoin/lastDay'),
			 $http.get('/api/ethereum/lastDay')
			 ]).then(function(arrayOfResults) {
				 
		var btc = arrayOfResults[0].data;
		var ltc = arrayOfResults[1].data;
		var eth = arrayOfResults[2].data;

		console.log();

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['dailyBufferBTC'] = loadValues(btc);
		$scope.buf['dailyBufferLTC'] = loadValues(ltc);
		$scope.buf['dailyBufferETH'] = loadValues(eth);

		$scope.canvas = document.getElementById("daily");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ {
					data : $scope.buf['dailyBufferBTC'],
					label : 'BTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				},
				{
					data : $scope.buf['dailyBufferLTC'],
					label : 'LTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 150)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				},
				{
					data : $scope.buf['dailyBufferETH'],
					label : 'ETH', // 'buy' price data
					borderColor : 'rgb(150, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				}
				]
			},
			options : {
				tooltips : {
					enabled : false
				},
				hover : {
					mode : null
				},
				showAllTooltips : false,
				legend : {
					display : true
				},
				legend : {
					display : true
				},
				title : {
					text : 'BTC/USD ( Bitcoin )', // chart title
					display : false
				},
				scales : {
					xAxes : [ {
						type : "time",
						time : {
							unit : 'minute',
							unitStepSize : 1,
							round : 'minute',
							tooltipFormat : "h:mm:ss a",
							displayFormats : {
								hour : 'MMM D, h:mm A'
							}
						}
					} ],
					yAxes : [ {
						gridLines : {
							color : "black",
							borderDash : [ 2, 5 ],
						}
					} ]
				}
			}
		});

	}, function(errResponse) {
		$scope.errorMessage = errResponse.data.errorMessage;
	});
	
	$q.all([ $http.get('/api/bitcoin/lastWeek'), 
		 $http.get('/api/litecoin/lastWeek'),
		 $http.get('/api/ethereum/lastWeek') ]).then(function(arrayOfResults) {
			 
	var btc = arrayOfResults[0].data;
	var ltc = arrayOfResults[1].data;
	var eth = arrayOfResults[2].data;

	$scope.chart = {};
	$scope.buf = {};
	$scope.buf['weeklyBufferBTC'] = loadValues(btc);
	$scope.buf['weeklyBufferLTC'] = loadValues(ltc);
	$scope.buf['weeklyBufferETH'] = loadValues(eth);
	
	$scope.canvas = document.getElementById("weekly");
	$scope.ctx = $scope.canvas.getContext("2d");
	$scope.chart = new Chart($scope.ctx, {
		type : 'line',
		data : {
			datasets : [ {
				data : $scope.buf['weeklyBufferBTC'],
				label : 'BTC', // 'buy' price data
				borderColor : 'rgb(65, 65, 65)', // line color
				backgroundColor : 'rgba(0,0,0,0.1)', // fill color
				fill : false, // no fill
				lineTension : 0.3
			},
			{
				data : $scope.buf['weeklyBufferLTC'],
				label : 'LTC', // 'buy' price data
				borderColor : 'rgb(65, 65, 150)', // line color
				backgroundColor : 'rgba(0,0,0,0.1)', // fill color
				fill : false, // no fill
				lineTension : 0.3
			},
			{
				data : $scope.buf['weeklyBufferETH'],
				label : 'ETH', // 'buy' price data
				borderColor : 'rgb(150, 65, 65)', // line color
				backgroundColor : 'rgba(0,0,0,0.1)', // fill color
				fill : false, // no fill
				lineTension : 0.3
			}
			]
		},
		options : {
			tooltips : {
				enabled : false
			},
			hover : {
				mode : null
			},
			showAllTooltips : false,
			legend : {
				display : true
			},
			legend : {
				display : true
			},
			title : {
				text : 'BTC/USD ( Bitcoin )', // chart title
				display : false
			},
			scales : {
				xAxes : [ {
					type : "time",
					time : {
						unit : 'day',
						unitStepSize : 1,
						round : 'day',
						tooltipFormat : "h:mm:ss a",
						displayFormats : {
							hour : 'MMM D, h:mm A'
						}
					}
				} ],
				yAxes : [ {
					gridLines : {
						color : "black",
						borderDash : [ 2, 5 ],
					}
				} ]
			}
		}
	});

}, function(errResponse) {
	$scope.errorMessage = errResponse.data.errorMessage;
});

	$q.all([ $http.get('/api/bitcoin/lastMonth'), 
			 $http.get('/api/litecoin/lastMonth'),
			 $http.get('/api/ethereum/lastMonth') ]).then(function(arrayOfResults) {
				 
		var btc = arrayOfResults[0].data;
		var ltc = arrayOfResults[1].data;
		var eth = arrayOfResults[2].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['monthlyBufferBTC'] = loadValues(btc);
		$scope.buf['monthlyBufferLTC'] = loadValues(ltc);
		$scope.buf['monthlyBufferETH'] = loadValues(eth);
		
		$scope.canvas = document.getElementById("monthly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ {
					data : $scope.buf['monthlyBufferBTC'],
					label : 'BTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				}, 
				{
					data : $scope.buf['monthlyBufferLTC'],
					label : 'LTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 150)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				},
				 {
					data : $scope.buf['monthlyBufferETH'],
					label : 'ETH', // 'buy' price data
					borderColor : 'rgb(150, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				 }
				]
			},
			options : {
				tooltips : {
					enabled : false
				},
				hover : {
					mode : null
				},
				showAllTooltips : false,
				legend : {
					display : true
				},
				legend : {
					display : true
				},
				title : {
					text : 'BTC/USD ( Bitcoin )', // chart title
					display : false
				},
				scales : {
					xAxes : [ {
						type : "time",
						time : {
							unit : 'day',
							unitStepSize : 1,
							round : 'day',
							tooltipFormat : "h:mm:ss a",
							displayFormats : {
								hour : 'MMM D, h:mm A'
							}
						}
					} ],
					yAxes : [ {
						gridLines : {
							color : "black",
							borderDash : [ 2, 5 ],
						}
					} ]
				}
			}
		});
	}, function(errResponse) {
		$scope.errorMessage = errResponse.data.errorMessage;
	});
	

	$q.all([ $http.get('/api/bitcoin/lastYear'),
			 $http.get("/api/litecoin/lastYear"),
			 $http.get("/api/ethereum/lastYear")]).then(function(arrayOfResults) {
		var btc = arrayOfResults[0].data;
		var ltc = arrayOfResults[1].data;
		var eth = arrayOfResults[2].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['yearlyBufferBTC'] = loadValues(btc);
		$scope.buf['yearlyBufferLTC'] = loadValues(ltc);
		$scope.buf['yearlyBufferETH'] = loadValues(eth);

		$scope.canvas = document.getElementById("yearly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ {
					data : $scope.buf['yearlyBufferBTC'],
					label : 'BTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				}, 
				{
					data : $scope.buf['yearlyBufferLTC'],
					label : 'LTC', // 'buy' price data
					borderColor : 'rgb(65, 65, 150)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				}, 
				{
					data : $scope.buf['yearlyBufferETH'],
					label : 'ETH', // 'buy' price data
					borderColor : 'rgb(150, 65, 65)', // line color
					backgroundColor : 'rgba(0,0,0,0.1)', // fill color
					fill : false, // no fill
					lineTension : 0.3
				}]
			},
			options : {
				tooltips : {
					enabled : false
				},
				hover : {
					mode : null
				},
				showAllTooltips : false,
				legend : {
					display : true
				},
				title : {
					text : 'BTC/USD ( Bitcoin )', // chart title
					display : false
				},
				scales : {
					xAxes : [ {
						type : "time",
						time : {
							unit : 'month',
							unitStepSize : 2
						}
					} ],
					yAxes : [ {
						gridLines : {
							color : "black",
							borderDash : [ 2, 5 ],
						}
					} ]
				}
			}
		});
	}, function(errResponse) {
		$scope.errorMessage = errResponse.data.errorMessage;
	});
});

function loadValues(data) {
	var arr = [];
	for (var i = 0; i < data.length; i++) {
		var val = data[i];
		var valDate = val["exchangetime"];
		var date = new Date(valDate);
		arr.push({
			x : ((date.getTime()) + 3600),
			y : val["exchangevalue"]
		});
	}
	return arr;
}