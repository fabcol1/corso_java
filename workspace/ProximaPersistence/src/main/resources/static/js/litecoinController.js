app.controller('litecoinController', function($scope, $http, $location, $route,
		$log, $q) {
	// HANDLE MULTIPE HTTP REQUEST WITH ANGULARJS
	$q.all([  $http.get('/api/litecoin/lastDay')
			 ]).then(function(arrayOfResults) {

		var ltc = arrayOfResults[0].data;

		console.log();

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['dailyBufferLTC'] = loadValues(ltc);

		$scope.canvas = document.getElementById("daily");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
				{
					data : $scope.buf['dailyBufferLTC'],
					label : 'LTC', // 'buy' price data
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
					text : 'LTC/USD ( Litecoin )', // chart title
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
	
	$q.all([ $http.get('/api/litecoin/lastWeek') ]).then(function(arrayOfResults) {
			 
	var ltc = arrayOfResults[0].data;

	$scope.chart = {};
	$scope.buf = {};
	$scope.buf['weeklyBufferLTC'] = loadValues(ltc);
	
	$scope.canvas = document.getElementById("weekly");
	$scope.ctx = $scope.canvas.getContext("2d");
	$scope.chart = new Chart($scope.ctx, {
		type : 'line',
		data : {
			datasets : [ 
			{
				data : $scope.buf['weeklyBufferLTC'],
				label : 'LTC', // 'buy' price data
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
				text : 'LTC/USD ( Litecoin)', // chart title
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

	$q.all([ $http.get('/api/litecoin/lastMonth') ]).then(function(arrayOfResults) {

		var ltc = arrayOfResults[0].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['monthlyBufferLTC'] = loadValues(ltc);
		
		$scope.canvas = document.getElementById("monthly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
				 {
					data : $scope.buf['monthlyBufferLTC'],
					label : 'LTC', // 'buy' price data
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
					text : 'LTC/USD ( Litecoin )', // chart title
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
	

	$q.all([ $http.get("/api/litecoin/lastYear")]).then(function(arrayOfResults) {
		var ltc = arrayOfResults[0].data;

		$scope.chart = {};
		$scope.buf = {};
		$scope.buf['yearlyBufferLTC'] = loadValues(ltc);

		$scope.canvas = document.getElementById("yearly");
		$scope.ctx = $scope.canvas.getContext("2d");
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {
				datasets : [ 
				{
					data : $scope.buf['yearlyBufferLTC'],
					label : 'LTC', // 'buy' price data
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
					text : 'LTC/USD ( Litecoin )', // chart title
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