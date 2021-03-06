app.controller('listQuestionController', function($scope, $http, $location,
  $route) {
  $http({
    method: 'GET',
    url: '/api/question/'
  }).then(function(response) {
    $scope.questions = response.data;
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
      $scope.deleteResponse = response.data;

      if ($scope.deleteResponse.id == null) {
        console.log("Domanda Cancellata");
        $scope.deletePermission = false;
        $location.path("/list-all-questions");
        $route.reload();
      } else {
        $scope.notDeletable="Domanda non cancellabile!";
        console.log("La domanda non è cancellabile");
        $scope.deletePermission = true;
      }
    });
  }
  $scope.isChecked = function() {
    return true;
  };
});
