app.controller('homeController', function($rootScope, $scope,
                $http, $location, $route){    
	     $scope.testa = false ;
         if ($rootScope.authenticated) {
                $location.path("/");
                $scope.loginerror = false;
       } else {
                $location.path("/login");
                $scope.loginerror = true;
       }
});