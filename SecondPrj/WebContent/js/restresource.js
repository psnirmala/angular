var module=angular.module("RestClientModule", ["ngResource"]);
module.factory("Entry",function($resource){
	return $resource("rest/employee/:id",{"id":"@_id"},{
		
				"update":{
					"method":"PUT"
				}
			
			});
});