app.controller('updatePasswordController', function($scope, $http, $location, $routeParams, $route) {
  $scope.userId = $routeParams.id;
  $scope.pwdLength = false;

  $scope.submitUserForm = function() {
    if(($scope.user.password==$scope.passwordcheck) && !$scope.pwdLength){
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
  if($scope.user.password != null && ($scope.user.password.length<8 || $scope.user.password.length>50)){
      $scope.pwdLength = true;
  }else {
    $scope.pwdLength = false;
  }
}

  $scope.resetForm = function() {
    $scope.user.password = null;
    $scope.passwordcheck = null;
    console.log($scope.user);
  };
});
