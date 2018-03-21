var app = angular.module('app_survey', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/insert-new-question', {
		templateUrl : '/template/insertquestion.html',
		controller : 'insertQuestionController'
	}).when('/list-all-questions', {
		templateUrl : '/template/listquestions.html',
		controller : 'listQuestionController'
	}).when('/complete-survey', {
		templateUrl : '/template/survey.html',
		controller : 'surveyController'
//	}).otherwise({
//		redirectTo : '/registration.html',
//		templateUrl : '/template/user.html'
	});
});