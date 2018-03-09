app.controller('listUserController', function($scope, $http, $location, $route) {
    $http({
            method : 'GET',
            url : 'http://localhost:8080/api/user/'
    }).then(function(response) {
            $scope.users = response.data;
    });
    $scope.editUser = function(userId) {
            $location.path("/update-user/" + userId);
    }
    $scope.deleteUser = function(userId) {
            $http({
                    method : 'DELETE',
                    url : 'http://localhost:8080/api/user/' + userId
            })
                            .then(
                                            function(response) {
                                                    $location.path("/list-all-users");
                                                    $route.reload();
                                            });
    }
});