 angular.module('app', []).controller('myController', ['$scope','$http', function myController1($scope) {
	
	 	this.user = {name :"NITESH"};
	 	this.user1 = "NITESH";
	  
	 	 $http.get("http://localhost:8090/")
	     .success(
	    		 function(response) {
	    			 $scope.names = response.records;
	    		}
	     );
	 	
    }
  
  ]
  
  );