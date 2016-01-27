angular.module("directiveModule1",[])
.directive("firstDirective", function(){
	var content={
			template:"<h2>This is a test directive</h2>"
	};
	return content;
});