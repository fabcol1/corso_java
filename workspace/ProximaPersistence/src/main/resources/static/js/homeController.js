app.controller('homeController', function($rootScope, $scope,
                $http, $location, $route){    
	console.log("HOME CONTROLLER");
         if ($rootScope.authenticated) {
                $location.path("/");
                $scope.loginerror = false;
       } else {
                $location.path("/login");
                $scope.loginerror = true;
       }
});