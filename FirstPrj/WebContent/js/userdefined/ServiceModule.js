var module=angular.module("ServiceMod",[]);
module.service("EmployeeService", function() {
	this.getData=function(){
		var data=[];
		data.push({"id":1,"name":"Rajiv","designation":"Developer"});
		data.push({"id":2,"name":"Arjun","designation":"Accountant"});
		data.push({"id":3,"name":"Arvind","designation":"Developer"});
		return data;
	};
	
});