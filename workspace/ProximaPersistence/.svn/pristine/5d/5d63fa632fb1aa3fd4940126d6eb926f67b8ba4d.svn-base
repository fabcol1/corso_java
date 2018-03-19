app.controller('insertQuestionController', function($scope, $http, $location,
  $route) {
  $http({
    method: 'GET',
    url: '/api/questionCategory/'
  }).then(function(response) {
    $scope.questionCategories = angular.fromJson(response.data);
    console.log($scope.questionCategories);
  });
//  toggleCheck(qc.id)
//  $scope.toggleCheck = function(categoryId) {
//	    console.log(categoryId);
//  }
  $scope.checkedCategories = [];
  $scope.toggleCheck = function (categoryId) {
      if ($scope.checkedCategories.indexOf(categoryId) === -1) {
          $scope.checkedCategories.push(categoryId);
      } else {
          $scope.checkedCategories.splice($scope.checkedCategories.indexOf(categoryId), 1);
      }
  };
  $scope.submitQuestionForm = function() {
    console.log("PRIMA: " + $scope.question);
    console.log($scope.checkedCategories);
    var checkedCategoriesLength = $scope.checkedCategories.length ;
//    var counter = 0 ;
    $scope.question.questiontags = [] ;
    for (var i=0; i<checkedCategoriesLength; i++) {
    	$scope.question.questiontags.push({"questioncategoryId":$scope.checkedCategories[i]});
//    	[i].questioncategoryId = $scope.checkedCategories[i];
    }

    console.log("DOPO: " + $scope.question);
    $http({
      method: 'POST',
      url: '/api/question/',
      data: $scope.question,
    }).then(function(response) {
      $location.path("/list-all-questions");
      $route.reload();
    }, function(errResponse) {
      $scope.errorMessage = errResponse.data.errorMessage;
    });
  }
  $scope.resetForm = function() {
    $scope.question = null;
  };
});
