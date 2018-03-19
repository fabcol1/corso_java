app
  .controller(
    'questionsDetailsController',
    function($scope, $http, $location, $routeParams, $route) {
      $scope.questionId = $routeParams.id;

      // Prendo le domande
      $http({
        method: 'GET',
        url: '/api/question/' +
          $scope.questionId
      }).then(function(response) {
        $scope.question = response.data;
        //console.log($scope.question);
      });

      // Prendo le question category relative alla domanda
      $http({
        method: 'GET',
        url: '/api/questionTag/' + $scope.questionId
      }).then(function(response) {
        console.log(response.data);
        $scope.questionCategories = response.data;
        console.log($scope.questionCategories);
        $scope.checkedCategories = [];
        $scope.checkedCategories = $scope.questionCategories;
        console.log("chekced");
        console.log($scope.checkedCategories);

        // Creo nuovo array con indici id delle categorie
        $scope.checkedCat = [];
        for (var k = 0; k < $scope.checkedCategories.length; k++) {
          $scope.checkedCat.push($scope.checkedCategories[k].id);
        }
                console.log("chekcehhhhhhhhhhhhhhhhhd");
        console.log($scope.checkedCat);
        // Prendo TUTTE le question category
        $http({
          method: 'GET',
          url: '/api/questionCategory/'
        }).then(function(response2) {

          // da TUTTE seleziono solo quelle non checked
          $scope.questionCategoriesAll = response2.data;
          $scope.notcheckedCategories = [];
          $scope.notcheckedCategories = angular.fromJson($scope.questionCategoriesAll);
          console.log("all cat");
          console.log($scope.notcheckedCategories);
          console.log($scope.questionCategoriesAll);
          for (var i = 0; i < $scope.notcheckedCategories.length; i++) {
            for (var j = 0; j < $scope.checkedCategories.length; j++) {
              if ($scope.notcheckedCategories[i].id == $scope.checkedCategories[j].id) {
                $scope.notcheckedCategories.splice(i, 1);
              }
            }
          }
        });
      });


      $scope.toggleCheck = function(categoryId) {
        if ($scope.checkedCat.indexOf(categoryId) === -1) {
                  console.log("inserita");
          $scope.checkedCat.push(categoryId);
        } else {
          console.log("eliminata");

          $scope.checkedCat.splice($scope.checkedCat.indexOf(categoryId), 1);
        }
      };

      $scope.submitQuestionForm = function() {
        //console.log("PRIMA: " + $scope.question);
        //console.log($scope.checkedCat);
        var checkedCatLength = $scope.checkedCat.length;
        //    var counter = 0 ;
        $scope.question.questiontags = [];
        for (var i = 0; i < checkedCatLength; i++) {
          console.log("inseritaaaaaaaaaaaaa");
          $scope.question.questiontags.push({"questioncategoryId": $scope.checkedCat[i]
          });
          //    	[i].questioncategoryId = $scope.checkedCategories[i];
          //  console.log($scope.checkedCategories[i]);
        }
        //  console.log($scope.question.questiontags);

        //  console.log("DOPO: " + $scope.question);


        $http({
            method: 'PUT',
            url: '/api/question/' +
              $scope.questionId,
            data: $scope.question,
          })
          .then(
            function(response) {
              $location
                .path("/list-all-questions");
              $route.reload();
            },
            function(errResponse) {
              $scope.errorMessage = "Error while updating Question - Error Message: '" +
                errResponse.data.errorMessage;
            });
      }
    });
