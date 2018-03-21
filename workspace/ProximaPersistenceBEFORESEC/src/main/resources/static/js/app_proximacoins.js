var app = angular.module('proximacoins', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/show-charts-BTC', {
		templateUrl : '/template/bitcoin.html',
		controller : 'bitcoinController'
	}).when('/show-charts-LTC', {
		templateUrl : '/template/litecoin.html',
		controller : 'litecoinController'
	}).when('/show-charts-ETH', {
		templateUrl : '/template/ethereum.html',
		controller : 'ethereumController'
	}).otherwise({
		redirectTo : '/template/bitcoin.html',
		templateUrl : 'bitcoinController',
	});
});


//will NOT throw violation
document.addEventListener("wheel", function(e) {
  e.preventDefault(); // does nothing since the listener is passive
}, {
  passive: true
});