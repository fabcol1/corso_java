app.controller('userController', function($scope, $http, $location, $routeParams, $route) {
	$scope.userId = $routeParams.id;	
    $http({
            method : 'GET',
            url : '/api/user/' + $scope.userId
    }).then(function(response) {
            $scope.user = response.data;
    });
    $scope.submitUserForm = function() {
        $http({
                method : 'PUT',
                url : '/api/user/updateUser/' + $scope.userId,
                data : $scope.user
        }).then(
                function(response) {
//                        $location.path("/update-singleUser/"+id);
                        $route.reload();
                },
                function(errResponse) {
                        $scope.errorMessage = "Error while updating User - Error Message: '" + errResponse.data.errorMessage;
                });
            }
    });