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
               console.log("About to add the following todo " + JSON.stringify($scope.newTodo));

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

              $scope.deleteTodo = function(todoID) {
              console.log("About to delete the following todo" + JSON.stringify(todoID));

              $http.get("http://localhost:8080/delete.json?todoID=" + todoID)
               .then(
                   function successCallback(response) {
                       alert("Successful delete =D")
                       console.log(response.data);
                       console.log("deleting data");
                       $scope.todos = response.data;
                   },
                   function errorCallback (response) {
                       console.log("Unable to delete");
                   });
              };

              $scope.toggleTodo = function(todoID) {
                console.log("About to toggle todo with ID " + JSON.stringify(todoID));

                $http.get("http://localhost:8080/toggle.json?todoID=" + todoID)
                .then(
                    function successCallback(response) {
                        alert("Successful toggle!");
                        console.log(response.data);
                        console.log("toggling data...");
                        $scope.todos = response.data;
                        },
                    function errorCallback(response) {
                        (console.log("unable to toggle"));
                    });
                };



        $scope.newTodo = {};


    });
