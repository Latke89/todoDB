angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {
        $scope.name = "James";

           $scope.getGames = function() {
               console.log("About to go get me some data!");

               $http.get("http://localhost:8080/todos.json")
                   .then(
                       function successCallback(response) {
                           console.log(response.data);
                           console.log("Adding data to scope");
                           $scope.todos = response.data;
                       },
                       function errorCallback(response) {
                           console.log("Unable to get data");
                       });
               console.log("Done with the promise, waiting for the callback")
           };


        $scope.newGame = {};
    });
