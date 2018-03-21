app.controller('recoveryPasswordController', function($scope, $http, $location, $routeParams, $route) {
  $scope.user = "";
  $scope.emailPresent = true;
  $scope.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
  $scope.userId = $routeParams.id;


  $scope.checkEmail = function(email) {
    if (email != "") {
      $http({
        method: 'GET',
        url: '/api/user/email/' + email,
        data: $scope.user,
      }).then(function(response) {
          $scope.emailPresent = true;
          $http({
              method: 'POST',
              url: '/api/usertoken/',
              data: $scope.user,
            })
            .then(function(response) {
              console.log("ciao5");
                $scope.pwdUpdate = true;
              },
              function(errResponse) {
                console.log("ciao6");
                $scope.pwdUpdate = false;
                $scope.errorMessage = "Error while updating User - Error Message: " + errResponse.data.errorMessage;
              });
        },
        function(errResponse) {
          console.log("ciao3");
          $scope.emailPresent = false;
        });
    }
  }

  $scope.resetForm = function() {
    $scope.user.email = null;
  };
});
