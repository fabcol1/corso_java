app.controller('chartsController', function($scope, $http, $location,
        $route, $log) {

	$scope.lastDay = function() {
    	$http({
			method : 'GET',
			url : 'http://localhost:8080/api/bitcoin/lastDay'
		}).then(function(response) {
//			console.log(response.data);
			var data = response.data;
			$scope.chart = {};
			$scope.buf = {};
			$scope.buf['dailyBuffer'] = [];
			for (var i = 0; i < data.length; i++) {
				var bitcoin = data[i];
//				console.log(bitcoin);
				var bitcoinDate = bitcoin["exchangetime"];
				var date = new Date(bitcoinDate);
				$scope.buf['dailyBuffer'].push({
					x : ((date.getTime()) + 3600),
					y : bitcoin["exchangevalue"]
				});
			}
			
//			$scope.mydiv = document.getElementById("mydiv");
//			$scope.oldCanvas = document.getElementById("results-graph");
//			if($scope.oldCanvas!=null) { $scope.oldCanvas.remove(); }
//			$scope.mydiv.append('<canvas id="results-graph"><canvas>');
//			$scope.canvas = document.getElementById('results-graph');
//			console.log($scope.canvas);
			  
			$scope.canvas = document.getElementById("daily");
			$scope.ctx = $scope.canvas.getContext("2d");
			$scope.chart = new Chart($scope.ctx, {
				type : 'line',
				data : {
					datasets : [ {
						data : $scope.buf['dailyBuffer'],
						label : 'Valore', // 'buy' price data
						borderColor : 'rgb(65, 65, 65)', // line color
						backgroundColor : 'rgba(0,0,0,0.1)', // fill color
						fill : true, // no fill
						lineTension : 0.3
					// straight line
					} ]
				},
				options : {
					legend: {
			            display: false
			        },
					title : {
						text : 'BTC/USD ( Bitcoin )', // chart title
						display : true
					}, 
					scales: {
					    xAxes: [{
					      type: "time",
					      time: {
					        unit: 'minute',
					        unitStepSize: 1,
					        round: 'minute',
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
			
		}, function(errResponse) {
	    	  $scope.errorMessage = errResponse.data.errorMessage;
	    });
    }; 
		
	$scope.lastMonth = function() {
    	$http({
			method : 'GET',
			url : 'http://localhost:8080/api/bitcoin/lastMonth'
		}).then(function(response) {
//			console.log(response.data);
			var data = response.data;
			$scope.chart = {};
			$scope.buf = {};
			$scope.buf['monthlyBuffer'] = [];
			for (var i = 0; i < data.length; i++) {
				var bitcoin = data[i];
//				console.log(bitcoin);
				var bitcoinDate = bitcoin["exchangetime"];
				var date = new Date(bitcoinDate);
				$scope.buf['monthlyBuffer'].push({
					x : ((date.getTime()) + 3600),
					y : bitcoin["exchangevalue"]
				});
			}
			$scope.canvas = document.getElementById("monthly");
			$scope.ctx = $scope.canvas.getContext("2d");
			$scope.chart = new Chart($scope.ctx, {
				type : 'line',
				data : {
					datasets : [ {
						data : $scope.buf['monthlyBuffer'],
						label : 'Valore', // 'buy' price data
						borderColor : 'rgb(65, 65, 65)', // line color
						backgroundColor : 'rgba(0,0,0,0.1)', // fill color
						fill : true, // no fill
						lineTension : 0.3
					// straight line
					} ]
				},
				options : {
//					legend: {
//			            display: false
//			        },
					title : {
						text : 'BTC/USD ( Bitcoin )', // chart title
						display : true
					}, 
					scales: {
					    xAxes: [{
					      type: "time",
					      time: {
					        unit: 'day',
					        unitStepSize: 1,
					        round: 'day',
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
			
		}, function(errResponse) {
	    	  $scope.errorMessage = errResponse.data.errorMessage;
	    });
    }; 
	
	$scope.lastYear = function() {
    	$http({
			method : 'GET',
			url : 'http://localhost:8080/api/bitcoin/lastYear'
		}).then(function(response) {
//			console.log(response.data);
			var data = response.data;
			$scope.chart = {};
			$scope.buf = {};
			$scope.buf['yearlyBuffer'] = [];
			for (var i = 0; i < data.length; i++) {
				var bitcoin = data[i];
//				console.log(bitcoin);
				var bitcoinDate = bitcoin["exchangetime"];
				var date = new Date(bitcoinDate);
				$scope.buf['yearlyBuffer'].push({
					x : ((date.getTime()) + 3600),
					y : bitcoin["exchangevalue"]
				});
			}
			$scope.canvas = document.getElementById("yearly");
			$scope.ctx = $scope.canvas.getContext("2d");
			$scope.chart = new Chart($scope.ctx, {
				type : 'line',
				data : {
					datasets : [ {
						data : $scope.buf['yearlyBuffer'],
						label : 'Valore', // 'buy' price data
						borderColor : 'rgb(65, 65, 65)', // line color
						backgroundColor : 'rgba(0,0,0,0.1)', // fill color
						fill : true, // no fill
						lineTension : 0.3
					// straight line
					} ]
				},
				options : {
//					legend: {
//			            display: false
//			        },
					title : {
						text : 'BTC/USD ( Bitcoin )', // chart title
						display : true
					}, 
					scales: {
					    xAxes: [{
					      type: "time",
					      time: {
					        unit: 'month',
					        unitStepSize: 2,
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
			
		}, function(errResponse) {
	    	  $scope.errorMessage = errResponse.data.errorMessage;
	    });
    }; 

});