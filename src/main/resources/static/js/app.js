var app = angular.module("Bank",[]);
app.controller("BankController", function($scope,$http) {
	$scope.compte = null;
	$scope.codeCompte = null;
	$scope.operation ={
		type: "versement",
		montant:0
	};
	$scope.pageOperations = [];
	$scope.pageCourante = 0;
	$scope.sizePage = 3;
	$scope.pages =[];
	$scope.nombrePages = null ;
	$scope.loadOperations = function() {
		$http.get("/operations?code="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.sizePage).then(function success(response) {
			$scope.pageOperations = response.data;
			$scope.nombrePages = response.data.nombrePages;
			$scope.pages = new Array(response.data.nombrePages);
		});
	};
	$scope.chargerCompte = function(){
		$scope.pageCourante =0 ;
		$http.get("/comptes/"+$scope.codeCompte)
		.then(function success(response) {
			$scope.compte = response.data;
			if(response.data.type == "CC")
				$scope.compte.type = "Current Account";
			else $scope.compte.type = "Savings Account";
			$scope.loadOperations();
		})
	};
	$scope.goToPage = function(index) {
		$scope.pageCourante = index;
		$scope.loadOperations();
	};
	$scope.process = function() {
		$http({
			method: 'PUT',
			url: $scope.operation.type,
			data: "code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmploye=1",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		}).then(function success(response) {
			$scope.chargerCompte();
			$scope.loadOperations();
		})
	}
});