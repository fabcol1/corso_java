app.controller('logoutController', function($rootScope, $scope,
                $http, $location, $route){        
        $http.post('logout', {}).finally(function() {
            $rootScope.authenticated = false;
            $location.path("/");
        });
});