angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {
        $scope.name = "James";

           $scope.getTodos = function() {
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

           $scope.addTodo = function() {
               console.log("About to add the following todo " + JSON.stringify($scope.newGame));

               $http.post("/addTodo.json", $scope.newTodo)
                   .then(
                       function successCallback(response) {
                           console.log(response.data);
                           console.log("Adding data to scope");
                           $scope.games = response.data;
                       },
                       function errorCallback(response) {
                           console.log("Unable to get data");
                       });
           };



        $scope.newTodo = {};
    });
