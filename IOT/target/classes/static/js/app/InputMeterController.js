'use strict';

angular.module('IOT').controller('InputMeterController',function($scope,$uibModalInstance){
	 
	 $scope.cancelModal = function(){
	 console.log("cancelmodal");
	 $uibModalInstance.dismiss('close');
	 }
	 $scope.ok = function(){
	 $uibModalInstance.close('save'); 
	 }
	 
	});