var app = angular.module('user_home', [ 'ngRoute', 'ngResource' ]);

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
	}).when('/login', {
		templateUrl : '/template/login.html',
		controller : 'loginController'		
//	}).otherwise({
//		redirectTo : '/registration.html',
//		templateUrl : '/template/user.html'
	});
});