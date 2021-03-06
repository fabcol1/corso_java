var app = angular.module('userregistrationsystem', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/template/home.html',
		controller : 'homeController'
	}).when('/list-all-users', {
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
	}).when('/recovery-userPasswordPt2/:token', {
		templateUrl : '/template/recoverypasswordPt2.html',
		controller : 'resetPasswordControllerPt2'
	}).when('/recovery-userPassword', {
		templateUrl : '/template/recoverypassword.html',
		controller : 'recoveryPasswordController'
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
	}).when('/logout', {
		templateUrl : '/template/login.html',
		controller : 'logoutController'
	}).when('/response-survey', {
		templateUrl : '/template/responseSurvey.html'
	}).otherwise({
		redirectTo : '/login',
	});
});

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);