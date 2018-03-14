app.controller('ethereumController', function($scope, $http, $location, $route,
		$log, $q) {
	// HANDLE MULTIPE HTTP REQUEST WITH ANGULARJS
	$q.all([  $http.get('/api/ethereum/lastDay')
			 ]).then(function(arrayOfResults) {

		var eth = arrayOfResults[0].data;

		console.log();

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['dailyBufferETH'] = loadValues(eth);

		$scope.canvas = document.getElementById("daily");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
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
					text : 'ETH/USD ( Ethereum )', // chart title
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
	
	$q.all([ $http.get('/api/ethereum/lastWeek') ]).then(function(arrayOfResults) {
			 
	var eth = arrayOfResults[0].data;

	$scope.chart = {};
	$scope.buf = {};
	$scope.buf['weeklyBufferETH'] = loadValues(eth);
	
	$scope.canvas = document.getElementById("weekly");
	$scope.ctx = $scope.canvas.getContext("2d");
	$scope.chart = new Chart($scope.ctx, {
		type : 'line',
		data : {
			datasets : [ 
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
				text : 'ETH/USD ( Ethereum)', // chart title
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

	$q.all([ $http.get('/api/ethereum/lastMonth') ]).then(function(arrayOfResults) {

		var eth = arrayOfResults[0].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['monthlyBufferETH'] = loadValues(eth);
		
		$scope.canvas = document.getElementById("monthly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
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
					text : 'ETH/USD ( Ethereum )', // chart title
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
	

	$q.all([ $http.get("/api/ethereum/lastYear")]).then(function(arrayOfResults) {
		var eth = arrayOfResults[0].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['yearlyBufferETH'] = loadValues(eth);

		$scope.canvas = document.getElementById("yearly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
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
					text : 'ETH/USD ( Ethereum )', // chart title
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