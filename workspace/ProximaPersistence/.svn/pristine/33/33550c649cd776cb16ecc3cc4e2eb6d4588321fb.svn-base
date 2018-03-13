app.controller('usersDetailsController',function($scope, $http, $location, $routeParams, $route) {
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
		                        url : '/api/user/admin/'+ $scope.userId,
		                        data : $scope.user,
		                })
		                .then(
                                function(response) {
                                        $location.path("/list-all-users");
                                        $route.reload();
                                },
                                function(errResponse) {
                                        $scope.errorMessage = "Error while updating User - Error Message: " + errResponse.data.errorMessage;
                                });
		                }
		        $scope.resetForm = function() {
		        	$scope.user.email = null;
		        	$scope.user.password = null;
		        	$scope.user.firstname = null;
		        	$scope.user.lastname = null;
		        	$scope.user.dateofbirth = null;		        	
		            console.log($scope.user);
		        };
});