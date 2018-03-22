app.controller('litecoinController', function($scope, $http, $location, $route, $log, $q) {
	
	$scope.weeklyDisplay=false;
	$scope.monthlyDisplay=false;
	$scope.yearlyDisplay=false;
	
		var cryptocurrencyId = 2 ;
	$http({
		method : 'GET',
		url : '/api/litecoin/lastvalues/' + cryptocurrencyId
	}).then(function(response) {
		$scope.lastvalues = response.data;			
		
		console.log("$scope.lastvalues: " + $scope.lastvalues);
	});
	
	$http({
		method : 'GET',
		url : '/api/provider/'
	}).then(function(response) {
		$scope.providers = response.data;	
		$scope.labels = [];
		$scope.colors = [];
		for(var i = 0 ; i < $scope.providers.length ; i++){			
			$scope.labels.push($scope.providers[i].label);
			var r=65,g=65,b=65;
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
				r=25+Math.floor(Math.random()*100);
				g=25+Math.floor(Math.random()*100);
				b=25+Math.floor(Math.random()*100);
			}
			var linea = 'rgb('+r+', '+g+', '+b+')';
			$scope.colors.push(linea);
		}		
//		$scope.labels = ['Okex', 'Bitstamp', 'Btcc', 'Coinmarketcap', 'Yogit'];
//		$scope.colors = ['rgb(65, 65, 65)', 'rgb(150, 65, 65)', 'rgb(65, 150, 65)', 'rgb(65, 65, 150)', 'rgb(65, 150, 150)'];
	
		chartGeneratorForLite($http, $scope, $q, '/api/litecoin/lastDay/', 'LTC/USD ( Litecoin )', 'minute', 'daily');
		if ($scope.weeklyDisplay) {
		chartGeneratorForLite($http, $scope, $q, '/api/litecoin/lastWeek/',  'LTC/USD ( Litecoin )', 'day', 'weekly');
		}
		if ($scope.monthlyDisplay) {
		chartGeneratorForLite($http, $scope, $q, '/api/litecoin/lastMonth/', 'LTC/USD ( Litecoin )', 'day', 'monthly');
		}
		if ($scope.yearlyDisplay) {
		chartGeneratorForLite($http, $scope, $q, '/api/litecoin/lastYear/',  'LTC/USD ( Litecoin )', 'month', 'yearly');
		}
	});
});

function chartGeneratorForLite($http, $scope, $q, urlBase, chartTitle, unit, elementId) {
	var actions = [];
	for(var i = 0; i < $scope.providers.length; i++) {
		actions.push($http.get(urlBase+$scope.providers[i].id));
	}
	
	// HANDLE MULTIPE HTTP REQUEST WITH ANGULARJS
	$q.all(actions).then(function(arrayOfResults) {

		$scope.chart = {};
		var datasets = [];

		for(var i = 0; i < arrayOfResults.length; i++) {
			if (arrayOfResults[i].data.length>0) {
				datasets.push(datasetGenerator(loadValues(arrayOfResults[i].data), $scope.labels[i], $scope.colors[i]  ));	
			}
			
		}

		var options = {
					tooltips : {
						enabled : false
					},
					hover : {
						mode : null
					},
					elements: { 
						point: { 
							radius: 0 
							}
					}, 
					showAllTooltips : false,
					legend : {
						display : true
					},					
					title : {
						text : chartTitle, // chart title
						display : true
					},
					scales : {
						xAxes : [ {
							type : "time",
							time : {
								unit : unit,
								unitStepSize : 1,
								round : unit,
							}
						} ],
						yAxes : [ {
							gridLines : {
								color : "black",
								borderDash : [ 2, 5 ],
					} } ] }};
		
		$scope.canvas = document.getElementById(elementId);
		$scope.ctx = $scope.canvas.getContext("2d");
		
		$scope.chart = new Chart($scope.ctx, {
			type : 'line',
			data : {  datasets : datasets },
			options : options
		});
	}, function(errResponse) {
		$scope.errorMessage = errResponse.data.errorMessage;
	});
}
	
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

function datasetGenerator(data, label, color) {
	return {
		data : data,
		label : label, // 'buy' price data
		borderColor : color, // line color
		backgroundColor : 'rgba(0,0,0,0.1)', // fill color
		fill : false, // no fill
		lineTension : 0.3
	};
}