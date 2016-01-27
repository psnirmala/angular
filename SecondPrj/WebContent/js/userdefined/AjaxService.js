angular.module("ServiceModule",[]).
service("AjaxService", function($http) {
	
	this.getCustomerData=function(){
		var promise= $http.get("customers.json");
		return promise;
	};
	this.getCustomerListData=function(){
		var promise= $http.get("customerslist.json");
		return promise;
	};
	
this.postCustomerData=function(data){
		var promise=$http.post("test.jsp","id="+data.id+"&name="+data.name,
				{"headers":{"Content-Type":"application/x-www-form-urlencoded"}});
		return promise;
	};
/*	this.postCustomerData=function(data){
        var promise=$http.post("test.jsp",{},{"params":data});
        return promise;
    };*/
	
});
