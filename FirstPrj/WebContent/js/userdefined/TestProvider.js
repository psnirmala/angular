angular.module("testModule", []).
provider("testService", function() {
	
	this.setMessage=function(message){
		this.message=message;
		console.log(this.message);
	};
	var self=this;
	this.$get=function(){
		var svc={};
		svc.getMessage=function(name)
		{
			return self.message+" "+name;
		}
		return svc;
	}
	
});
