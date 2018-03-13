app.controller('listQuestionController', function($scope, $http, $location,
  $route) {
  $http({
    method: 'GET',
    url: '/api/question/'
  }).then(function(response) {
    $scope.questions = response.data;
  });
  $http({
    method: 'GET',
    url: '/api/questionCategory/'
  }).then(function(response) {
    $scope.questionCategory = response.data;
  });
  // Se clicco su modifica....
  $scope.editQuestion = function(questionId) {
    $location.path("/update-question/" + questionId);
  }
    // Se clicco su delete....
  $scope.deleteQuestion = function(questionId) {
    $http({
      method: 'DELETE',
      url: '/api/question/' + questionId
    }).then(function(response) {
      $location.path("/list-all-questions");
      $route.reload();
    });
  }
  $scope.isChecked = function(){
	    return true;
	};
});