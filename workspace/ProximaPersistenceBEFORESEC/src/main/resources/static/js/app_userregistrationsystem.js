var app = angular.module('userregistrationsystem', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/list-all-users', {
		templateUrl : '/template/listuser.html',
		controller : 'listUserController'
	}).when('/register-new-user', {
		templateUrl : '/template/userregistration.html',
		controller : 'registerUserController'
	}).when('/update-singleUser/:id', {
		templateUrl : '/template/singleuserupdation.html',
		controller : 'userController'
	}).when('/update-user/:id', {
		templateUrl : '/template/userupdation.html',
		controller : 'usersDetailsController'
	}).when('/update-userPassword/:id', {
		templateUrl : '/template/updatepassword.html', 
		controller : 'updatePasswordController'
	}).when('/reset-userPassword/:id', {
		templateUrl : '/template/resetpassword.html', 
		controller : 'resetPasswordController'
	}).when('/show-charts', {
		templateUrl : '/template/charts.html',
		controller : 'chartsController'
	}).when('/show-charts-BTC', {
		templateUrl : '/template/bitcoin.html',
		controller : 'bitcoinController'
	}).when('/show-charts-LTC', {
		templateUrl : '/template/litecoin.html',
		controller : 'litecoinController'
	}).when('/show-charts-ETH', {
		templateUrl : '/template/ethereum.html',
		controller : 'ethereumController'
	}).when('/list-all-questions', {
		templateUrl : '/template/listquestions.html',
		controller : 'listQuestionController'
	}).when('/insert-new-question', {
		templateUrl : '/template/insertquestion.html',
		controller : 'insertQuestionController'
	}).when('/update-question/:id', {
		templateUrl : '/template/questionupdation.html',
		controller : 'questionsDetailsController'
	}).when('/login', {
		templateUrl : '/template/login.html',
		controller : 'loginController'
	}).when('/complete-survey', {
		templateUrl : '/template/survey.html',
		controller : 'surveyController'
	}).otherwise({
		redirectTo : '/home',
		templateUrl : '/template/home.html',
	});
});
