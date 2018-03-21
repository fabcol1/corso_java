app.controller('resetPasswordController', function($scope, $http, $location, $routeParams, $route) {
  $scope.userId = $routeParams.id;

  $scope.resetPassword = function() {
    $http({
        method: 'PUT',
        url: '/api/user/resetPassword/' + $scope.userId,
        data: $scope.user,
      })
      .then(
        function(response) {
          $scope.pwdUpdate=true;
          //$location.path("/list-all-users");
          //$route.reload();
        },
        function(errResponse) {
          $scope.errorMessage = "Error while updating User - Error Message: " + errResponse.data.errorMessage;
        });
  };
});
