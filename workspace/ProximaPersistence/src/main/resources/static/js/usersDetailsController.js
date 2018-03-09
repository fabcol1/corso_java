app.controller('usersDetailsController',function($scope, $http, $location, $routeParams, $route) {
		        $scope.userId = $routeParams.id;
		        $http({
		                method : 'GET',
		                url : 'http://localhost:8080/api/user/' + $scope.userId
		        }).then(function(response) {
		                $scope.user = response.data;
		        });
		        $scope.submitUserForm = function() {
		                $http({
		                        method : 'PUT',
		                        url : 'http://localhost:8080/api/user/',
		                        data : $scope.user,
		                })
		                .then(
                                function(response) {
                                        $location.path("/list-all-users");
                                        $route.reload();
                                },
                                function(errResponse) {
                                        $scope.errorMessage = "Error while updating User - Error Message: '" + errResponse.data.errorMessage;
                                });
		                }
});