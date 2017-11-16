var app = angular.module('IOT', ['ui.router', 'ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/IOT',
    USER_SERVICE_API: 'http://localhost:8080/IOT/meter'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/home',
                controller: 'HomeController',
                controllerAs: 'ctrl',
                
                resolve: {
                    meters: function ($q, MeterService) {
                        console.log('Load All Meter');
                        var deferred = $q.defer();
                        MeterService.loadAllMeter().then(deferred.resolve, deferred.resolve);
//                        console.log(deferred.promise);
                        return deferred.promise;
                    }
                }
            })
            .state('inputmeter', {
                url: '/inputmeter',
                templateUrl: 'partials/inputmeter',
                controller: 'InputMeterController',
                controllerAs: 'ctrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);

