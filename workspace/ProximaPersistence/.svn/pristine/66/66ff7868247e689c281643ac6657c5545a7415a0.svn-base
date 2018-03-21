app.controller('recoveryPasswordControllerPt2', function($scope, $http, $location, $routeParams, $route) {
  $scope.token = $routeParams.token;
  $scope.pwdLength = false;

  $http({
    method: 'GET',
    url: '/api/usertoken/getToken/' + $scope.token,
  }).then(function(response) {
      $scope.checkToken = true;
    },
    function(errResponse) {
      $scope.checkToken = false;
    });


  $scope.submitUserForm = function() {
    if (($scope.user.password == $scope.passwordcheck) && !$scope.pwdLength) {
      console.log($scope.user);
      $http({
          method: 'PUT',
          url: '/api/user/updatePassword/' + $scope.userId,
          data: $scope.user,
        })
        .then(
          function(response) {
            $scope.pwdUpdate = true;
          },
          function(errResponse) {
            $scope.errorMessage = "Error while updating User - Error Message: " + errResponse.data.errorMessage;
          });
    }
  }

  $scope.validatePwd = function() {
    if ($scope.user.password != null && ($scope.user.password.length < 8 || $scope.user.password.length > 50)) {
      $scope.pwdLength = true;
    } else {
      $scope.pwdLength = false;
    }
  }

  $scope.resetForm = function() {
    $scope.user.password = null;
    $scope.passwordcheck = null;
    console.log($scope.user);
  };
});
