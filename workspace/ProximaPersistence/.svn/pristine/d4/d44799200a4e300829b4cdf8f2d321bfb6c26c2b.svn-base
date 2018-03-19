app
		.controller(
				'userController',
				function($scope, $http, $location, $routeParams, $route, $q,
						fileUpload) {
					$scope.uploadError=false;
					$scope.uploadSucces=false;
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
						})
								.then(
										function(response) {
											// $location.path("/update-singleUser/"+id);
											$route.reload();
										},
										function(errResponse) {
											$scope.errorMessage = "Error while updating User - Error Message: '"
													+ errResponse.data.errorMessage;
										});
					}

					$scope.dataUpload = true;
					$scope.errVisibility = false;
					$scope.uploadFile = function() {
						var file = $scope.myFile;
						console.log('file is ');
						console.dir(file);
						console.log("aaaa" + file);
						var uploadUrl = "/api/user/fileUpload";
						fileUpload.uploadFileToUrl(file, uploadUrl).then(
								function(result) {
									$scope.errors = fileUpload.getResponse();
									console.log($scope.errors);
									$scope.errVisibility = true;
									$scope.uploadSucces=true;
									$scope.uploadSuccesText="Upload effettuato con successo!";
								}, function(error) {
									$scope.uploadError=true;
									$scope.uploadErrorText="Upload fallito! Riprova!";
									//alert('error');
								})
					};
				});

app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;
			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);

app.service('fileUpload', [ '$q', '$http', function($q, $http) {
	console.log("XXXXXXXXXXXXXX");
	var deffered = $q.defer();
	var responseData;
	console.log("DEBUG 1");
	this.uploadFileToUrl = function(file, uploadUrl) {
		var fd = new FormData();
		fd.append('file', file);
		console.log("uploadUrl: " + uploadUrl);
		return $http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function(response) {
			/* $scope.errors = response.data.value; */
			//$scope.uploadError=false;
			console.log(response);
			responseData = response;
			deffered.resolve(response);
			return deffered.promise;
		}).error(function(error) {

			deffered.reject(error);
			return deffered.promise;
		});
	}
	this.getResponse = function() {
		return responseData;
	}
} ]);

// app.controller('myCtrl', ['$scope', '$q', 'fileUpload', function($scope, $q,
// fileUpload){
// $scope.dataUpload = true;
// $scope.errVisibility = false;
// $scope.uploadFile = function(){
// var file = $scope.myFile;
// console.log('file is ' );
// console.dir(file);
// var uploadUrl = "<give-your-url>/continueFileUpload";
// fileUpload.uploadFileToUrl(file, uploadUrl).then(function(result){
// $scope.errors = fileUpload.getResponse();
// console.log($scope.errors);
// $scope.errVisibility = true;
// }, function(error) {
// alert('error');
// })
// };
// }]);
