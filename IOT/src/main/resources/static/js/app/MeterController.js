'use strict';

angular.module('IOT').controller('MeterController',
        ['MeterService', '$scope', function (MeterService, $scope) {

                var self = this;
                self.value = '0';
                self.partnerId = 'partnerId';
                self.bucketId = 'bucketId';
                self.startDate= new Date();
                self.endDate= new Date();
                self.meter = {
                        code: "",
                        meterType: false,
                        name: "",
                        pci: null,
                        pcs: null,
                        startDate: null,
                        status: false,
                        unit: "00"
                }
                self.meterChoose = {
                        code: "",
                        meterType: false,
                        name: "",
                        pci: null,
                        pcs: null,
                        startDate: null,
                        status: false,
                        unit: "00"
                }
                self.showInfo = showInfo;
                function showInfo(meter){
                        self.meterChoose = meter;
                }
                self.listMeter = [];
                this.listMeter = MeterService.loadAllMeter();
                self.submit = submit;
                self.reset = reset;
                self.onlyIntegers = /^\d+$/;
                self.onlyNumbers = /^\d+([,.]\d+)?$/;
                self.loadAllMeter = loadAllMeter;
                self.searchByBeweenDate = searchByBeweenDate;
                function submit() {
                        console.log(self.meter);
                        createMeter();
                }
                function reset() {
                        self.partnerId = 'partnerId';
                        self.bucketId = 'bucketId';
                        self.meter = {
                                code: "",
                                meterType: false,
                                name: "",
                                pci: null,
                                pcs: null,
                                startDate: null,
                                status: false,
                                unit: "00"
                        }
                }
                function searchByBeweenDate(){
                        MeterService.searchMeterByDate(this.startDate, this.endDate).then(function (data) {
                                self.listMeter = data.data;
                                console.log(data.data);
                        }).catch(function () {
                                $scope.error = 'unable to get posts';
                        });
                }

                MeterService.loadAllMeter().then(function (data) {
                        self.listMeter = data.data;
                        console.log(data.data);
                }).catch(function () {
                        $scope.error = 'unable to get posts';
                });

                function loadAllMeter(){
                	 MeterService.loadAllMeter().then(function (data) {
                         self.listMeter = data.data;
                         console.log(data.data);
                 }).catch(function () {
                         $scope.error = 'unable to get posts';
                 });
                }
                function createMeter() {
                    console.log('About to create user');
                    MeterService.createMeter(self.meter,'bucketId', 'partnerId')
                        .then(
                            function (response) {
                                console.log('Meter created successfully');
                                // self.successMessage = 'Meter created successfully';
                                self.errorMessage='';
                                self.done = true;
                                self.user={};
                                $scope.myForm.$setPristine();
                                reset();
                                loadAllMeter();
                            },
                            function (errResponse) {
                                console.error('Error while creating Meter');
                                // self.errorMessage = 'Error while creating Meter: ' + errResponse.data.errorMessage;
                                // self.successMessage='';
                            }
                        );
                }





                // function submit() {
                //     console.log('Submitting');
                //     if (self.user.id === undefined || self.user.id === null) {
                //         console.log('Saving New User', self.user);
                //         createUser(self.user);
                //     } else {
                //         updateUser(self.user, self.user.id);
                //         console.log('User updated with id ', self.user.id);
                //     }
                // }



                // function updateUser(user, id){
                //     console.log('About to update user');
                //     UserService.updateUser(user, id)
                //         .then(
                //             function (response){
                //                 console.log('User updated successfully');
                //                 self.successMessage='User updated successfully';
                //                 self.errorMessage='';
                //                 self.done = true;
                //                 $scope.myForm.$setPristine();
                //             },
                //             function(errResponse){
                //                 console.error('Error while updating User');
                //                 self.errorMessage='Error while updating User '+errResponse.data;
                //                 self.successMessage='';
                //             }
                //         );
                // }


                // function removeUser(id){
                //     console.log('About to remove User with id '+id);
                //     UserService.removeUser(id)
                //         .then(
                //             function(){
                //                 console.log('User '+id + ' removed successfully');
                //             },
                //             function(errResponse){
                //                 console.error('Error while removing user '+id +', Error :'+errResponse.data);
                //             }
                //         );
                // }


                // function getAllUsers(){
                //     return UserService.getAllUsers();
                // }

                // function editUser(id) {
                //     self.successMessage='';
                //     self.errorMessage='';
                //     UserService.getUser(id).then(
                //         function (user) {
                //             self.user = user;
                //         },
                //         function (errResponse) {
                //             console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                //         }
                //     );
                // }
                // function reset(){
                //     self.successMessage='';
                //     self.errorMessage='';
                //     self.user={};
                //     $scope.myForm.$setPristine(); //reset Form
                // }



        }


        ]);