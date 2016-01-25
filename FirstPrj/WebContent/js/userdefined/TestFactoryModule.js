angular.module("TestFactoryModule",[]).
factory("pizzaFactory", function() {
	var pizza={};
	pizza.getType=function(type)
	{
		if(type=="v"){
			return "Veg";
		}
		else if(type=="c"){
			return "Chicken";
		}
	};
	pizza.getPrice=function(type){
		if(type=="v"){
			return 500;
		}
		else if(type=="c"){
			return 600;
		}
	};
	return pizza;
});
