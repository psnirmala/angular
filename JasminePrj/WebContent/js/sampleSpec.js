describe("controller1",function(){//describe describes a test suite
	beforeEach(module("sample"));
	//it describes a test case
	it('should check whether message is welcome', inject(function ($controller, $rootScope) {
		var $scope = $rootScope.$new();
		$controller('controller1', {
			$scope: $scope
		});
		expect($scope.message).toEqual('Welcom');
	}));
			
			
	
}); 