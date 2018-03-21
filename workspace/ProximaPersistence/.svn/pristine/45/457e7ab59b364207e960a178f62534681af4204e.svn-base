app.controller('registerUserController', function($scope, $http, $location, $routeParams, $route) {

  $scope.pwdLength = false;

  $scope.submitUserForm = function() {
    $scope.user.regdate = new Date();
    $scope.user.role = 10;
    if (($scope.user.password == $scope.passwordcheck) && !$scope.pwdLength) {
      $http({
        method: 'POST',
        url: '/api/user/',
        data: $scope.user,
      }).then(function(response) {
        // console.log("$scope.user: " + $scope.user);
        $location.path("/list-all-users");
        $route.reload();
        $scope.pwdUpdate = true;
      }, function(errResponse) {
        $scope.errorMessage = errResponse.data.errorMessage;
				$scope.errorMessage = "Error while updating User - Error Message: " + errResponse.data.errorMessage;
      });
    }
  }

  $scope.validatePwd = function() {
    if ($scope.user.password != null && ($scope.user.password.length < 8 || $scope.user.password.length > 50)) {console.log('ciao');
      $scope.pwdLength = true;
    } else {
      $scope.pwdLength = false;
    }
  }

  // console.log("$scope.user: " + $scope.user);
  $scope.resetForm = function() {
    $scope.user = null;
  }

$scope.checkEmail = function(email) {
  if (email != "") {
    $http({
      method: 'GET',
      url: '/api/user/email/' + email,
    }).then(function(response) {
      console.log("dada");
      $scope.users = response.data;
      if ($scope.users.id != null) {
        console.log("fqwfwqf");
        $scope.emailPresent = true;

      } else {
        $scope.emailPresent = false;
      }
    });
  }
}
});
