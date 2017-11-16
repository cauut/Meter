'use strict';

angular.module('IOT').factory('MeterService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllMeter: loadAllMeter,
                searchMeterByDate: searchMeterByDate,
                // getUser: getUser,
                createMeter: createMeter
                // updateUser: updateUser,
                // removeUser: removeUser
            };

            return factory;

            function loadAllMeter() {
                console.log('Fetching all users');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                    function (response) {
                        console.log('Fetched successfully all users');
                        $localStorage.users = response.data;
                        console.log(response.data);
                        deferred.resolve(response);
                    },
                    function (errResponse) {
                        console.error('Error while loading users');
                        deferred.reject(errResponse);
                    }
                    );
                return deferred.promise;
            }

            function searchMeterByDate(startDate, endDate) {
                console.log('Search by Date');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API+ '/search/'+ startDate + '/' + endDate + '/')
                    .then(
                    function (response) {
                        console.log('search by date');
                        $localStorage.users = response.data;
                        console.log(response.data);
                        deferred.resolve(response);
                    },
                    function (errResponse) {
                        console.error('Error load meter');
                        deferred.reject(errResponse);
                    }
                    );
                return deferred.promise;
            }
            function createMeter(meter, bucketId, partnerId) {
                console.log('Creating meter');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API+ "/add_meter/" +bucketId + "/" +partnerId+"/", meter)
                    .then(
                    function (response) {
                        loadAllMeter();
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                        console.error('Error while creating Meter : ' + errResponse.data.errorMessage);
                        deferred.reject(errResponse);
                    }
                    );
                return deferred.promise;
            }

        }
    ]);