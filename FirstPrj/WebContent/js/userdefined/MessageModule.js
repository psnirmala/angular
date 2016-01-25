var module=angular.module("MessageMod",[]);
module.service("TestService", function() {
	this.getMessage=function(){
		return "This is a test service";
	};
	this.getNextMessage=function(){
		return "This is message from getNextMessage function of Test Service";
	};
	this.add=function(first,second){
		return first+second;
	}
});