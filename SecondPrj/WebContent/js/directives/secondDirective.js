angular.module("directiveModule2",[])
.directive("secondDirective", function(){
	var content={
			//template:"<h2>This is a test directive with {{city}} and {{state}}</h2>",
			"templateUrl":"templatecontent.html",
			scope:{
				"city":"=",
				"state":"="
			},
			"link":function(scope,element,attrs)
			{
				console.log("link");
				element.on("mouseenter",function(){
					console.log("mouse enter");
				//element.attr("style","color: lime");
					$(this).css("color","red");
				//$(this).css("backgroundColor","lime");

					
					
				});
				element.on("mouseleave",function(){
					$(this).css("color","black");
					
				});
				
			}
	};
	return content;
});