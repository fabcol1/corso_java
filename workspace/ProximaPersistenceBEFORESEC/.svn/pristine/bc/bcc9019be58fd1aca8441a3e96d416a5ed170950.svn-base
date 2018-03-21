app.controller('surveyController',
  function($scope, $http, $location, $route) {
    $http({
      method: 'GET',
      url: '/api/survey/1'
    }).then(function(response) {
      $scope.survey = response.data;
      $scope.questions = response.data.surveyquestions;
      $scope.starttime = new Date();
    });
    $scope.surveySubmit = function() {
    	$http({
			method : 'POST',
			url : '/api/survey/',
			data : createResponseJSON($scope),
		}).then(function(response) {
			// console.log("$scope.user: " + $scope.user);
			$location.path("/list-all-users");
			$route.reload();
		}, function(errResponse) {
			$scope.errorMessage = errResponse.data.errorMessage;
		});
    }
});

function createResponseJSON($scope) {
	var json = '{';
	json = json + '"surveyId" : ' + $scope.survey.id + ',';
	json = json + '"starttime" : "' + String($scope.starttime) + '",'
				+ '"endtime" : "' + String(new Date()) + '",' 
				+ '"userId" : 5, ';
	json = json + '"replies" : [';
	for(var i=0; i < $scope.questions.length; i++) {
		json = json + '{ "questionId": ' + $scope.questions[i].question.id + ', '
					+ '"answers" : ' + getCheckedBoxes($scope.questions[i].question.id);
		json = json + '},';
	}
	console.log(json.length);
	if(json.length > 1) {
		json = json.substring(0, json.length - 1);
	}
	json = json + '] }';
	console.log(json);
	return json;
}

function getCheckedBoxes(id) {
	  var checkboxes = document.getElementsByName(id);
	  var checkboxesChecked = '[';
	  for (var i=0; i<checkboxes.length; i++) {
	     if (checkboxes[i].checked) {
	        checkboxesChecked = checkboxesChecked + '"' + checkboxes[i].value + '"';
		    checkboxesChecked = checkboxesChecked + ',';
	     }
	  }
	  if(checkboxesChecked.length > 1){
		  checkboxesChecked = checkboxesChecked.substring(0, checkboxesChecked.length - 1);
	  }
	  checkboxesChecked = checkboxesChecked + ']';
	  return checkboxesChecked;
	}