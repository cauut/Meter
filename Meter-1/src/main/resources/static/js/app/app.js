var app = angular.module('meter_object', ['ui.router', 'ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/meter_object',
    USER_SERVICE_API: 'http://localhost:8080/meter_object/meter'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/app',
                controller: 'MeterController',
                controllerAs: 'ctrl',
                
                resolve: {
                    meters: function ($q, MeterService) {
                        console.log('Load All Meter');
                        var deferred = $q.defer();
                        MeterService.loadAllMeter().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

