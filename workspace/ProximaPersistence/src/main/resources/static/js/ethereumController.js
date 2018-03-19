app.controller('ethereumController', function($scope, $http, $location, $route,
		$log, $q) {
	$scope.providers=[];	
	$scope.weeklyDisplay=false;
	$scope.monthlyDisplay=false;
	$scope.yearlyDisplay=false;
	var cryptocurrencyId = 2 ;
	
	$http({
		method : 'GET',
		url : '/api/bitcoin/lastvalues/' + cryptocurrencyId
	}).then(function(response) {
		$scope.lastvalues = response.data;			
		
//		console.log("$scope.lastvalues: " + $scope.lastvalues);
	});
	
		
		$http({
			method : 'GET',
			url : '/api/provider/'
		}).then(function(response) {
			$scope.providers = response.data;				
//			console.log("numero di providers: "+$scope.providers.length);

			$scope.promises=[];
			for(var i = 0 ; i < $scope.providers.length ; i++){
				let promise = $http.get('/api/ethereum/lastDay/'+$scope.providers[i].id);
				$scope.promises.push(promise);
			}
//			console.log($scope.promises);
			// HANDLE MULTIPE HTTP REQUEST WITH ANGULARJS
			$q.all($scope.promises
					).then(function(arrayOfResults) {
						var btcArray=[];
				for(var i = 0 ; i < arrayOfResults.length ; i++){
					var btc = arrayOfResults[i].data;
					btcArray.push(btc);
				}
				
//				console.log(btcArray);
				$scope.chart = {};
				$scope.buf = {};
				$scope.buffers=[];
				for(var i = 0 ; i < btcArray.length ; i++){
					$scope.buffers.push($scope.buf['dailyBufferBTC'+i] = loadValues(btcArray[i]));
				}
//				console.log($scope.buffers);
//				console.log($scope.providers[0].label);
				$scope.dsets=[];
				for(var i = 0 ; i < btcArray.length ; i++){
//					console.log(Math.floor(Math.random()*100));
					var r=65;
					var g=65;
					var b=65;
					if(i==1){
						r=150;
					}
					if(i==2){
						g=150;
					}
					if(i==3){
						b=150;
					}
					if(i==4){
						g=150;
						b=150;
					}
					if(i>4){
						r=65+Math.floor(Math.random()*100);
						g=65+Math.floor(Math.random()*100);
						b=65+Math.floor(Math.random()*100);
					}
					
					var dset= {
							data : $scope.buffers[i],
							label : $scope.providers[i].label, // 'buy' price data
							borderColor : 'rgb('+r+', '+g+', '+b+')', // line color
							backgroundColor : 'rgba(0,0,0,0.1)', // fill color
							fill : false, // no fill
							lineTension : 0.3
						}
//					console.log(dset);
					$scope.dsets.push(dset);
				}
//				console.log($scope.dsets);
				$scope.canvas = document.getElementById("daily");
				$scope.ctx = $scope.canvas.getContext("2d");
				$scope.chart = new Chart($scope.ctx, {
					type : 'line',
					data : {
						datasets : $scope.dsets//							
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