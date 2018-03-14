app
  .controller(
    'questionsDetailsController',
    function($scope, $http, $location, $routeParams, $route) {
      $scope.questionId = $routeParams.id;
      $http({
        method: 'GET',
        url: '/api/question/' +
          $scope.questionId
      }).then(function(response) {
        $scope.question = response.data;
        console.log($scope.question);
      });
      $http({
        method: 'GET',
        url: '/api/questionTag/'+$scope.question.id
      }).then(function(response) {
        $scope.questionCategories = response.data;
      });
      $scope.submitQuestionForm = function() {
        console.log($scope.question);
        $http({
            method: 'PUT',
            url: '/api/question/' +
              $scope.questionId,
            data: $scope.question,
          })
          .then(
            function(response) {
              $location
                .path("/list-all-questions");
              $route.reload();
            },
            function(errResponse) {
              $scope.errorMessage = "Error while updating Question - Error Message: '" +
                errResponse.data.errorMessage;
            });
      }
    });
