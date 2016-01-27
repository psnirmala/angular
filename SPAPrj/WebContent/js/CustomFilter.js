angular.module("CustomFilterModule",[]).
filter("blueToRedConverter",function(){
	var filterFunction=function(text)
	{
		var replacedText=text.replace(/blue/gi,"red");
		return replacedText;
	};
	return filterFunction;
});