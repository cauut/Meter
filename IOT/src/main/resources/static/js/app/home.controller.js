'use strict';
angular.module('IOT').controller('HomeController',
        ['MeterService', '$scope','$window', function (MeterService, $scope,$window) {
        		
                

                var self = this;
                self.value = '0';
                self.partnerId = 'partnerId';
                self.bucketId = 'bucketId';
                self.listPulse=[];
                self.startDate= new Date();
                self.endDate= new Date();
                self.startDatePulse= new Date();
                self.endDatePulse= new Date();
                self.successMessage = '';
                self.errorMessage = '';
                self.showChart = false;
                self.category=['champ','champ','champ'];
        		self.data=[1,2,3,4];
                Highcharts.chart('chart', {
                    title: {
                      text: 'Offset Champsa Meter Chart'
                    },
              
                    xAxis: {
                      categories: self.category
                      
                    },
              
                    series: [{
                    	type: 'column',
                      data: self.data
                    }]
                });
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
                self.cancelFrom = cancelFrom;
                function cancelFrom(){
                	self.openForm= false;
                	self.titleAddMeter="hiden from add Meter"
                	
                	
                }
                function showInfo(meter){
                		self.showChart = false;
                		self.nameChart = "Show Chart";
                        self.meterChoose = meter;
                        showAllPulseOfMeter(meter.code);
                        if(self.openForm==true){
                        	self.openForm = !self.openForm;
                        	self.titleAddMeter="hiden from add Meter"
                        	
                        }
                        else self.titleAddMeter="Add Meter"
                }
                self.listMeter = [];
                this.listMeter = MeterService.loadAllMeter();
                self.initData = initData;
                self.submit = submit;
                self.reset = reset;
                self.onlyIntegers = /^\d+$/;
                self.onlyNumbers = /^\d+([,.]\d+)?$/;
                self.loadAllMeter = loadAllMeter;
                self.searchByBeweenDate = searchByBeweenDate;
                self.searchPulseRestrictDate = searchPulseRestrictDate;
                self.showAllPulseOfMeterChart = showAllPulseOfMeterChart;
                self.clickChartBtn = clickChartBtn;
                self.nameChart = "Show Chart";
                self.openForm=false	;
                self.titleAddMeter="Add Meter";
                self.showForm = showForm;
                
                function initDataChart(){
                	this.category=[];
                	category[0] ="NO CONTENT";
                	this.data=[];
                	data[0]=0;
                } 
                function submit() {
                        console.log(self.meter);
                        createMeter();
                        showInfo(meter);
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
                function showForm(){
                	self.openForm = !self.openForm;
                	if(self.openForm==false) self.titleAddMeter="Add Meter";
                	else self.titleAddMeter="hiden from add Meter";
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
                                self.successMessage = 'Meter created successfully';
                                self.errorMessage='';
                                self.done = true;
                                self.user={};
                                $scope.myForm.$setPristine();
                                reset();
                                loadAllMeter();
                            },
                            function (errResponse) {
                            	console.error('Error while updating Meter');
                                self.errorMessage='Error while updating Meter '+errResponse.data;
                                self.successMessage='';
                            }
                        );
                }
                function searchPulseRestrictDate(){
                	if(this.startDatePulse > this.endDatePulse){
                		$window.alert("StartDate large end Date. Search not execution.");
                	}
                	else
                	if(self.meterChoose!=null && self.meterChoose.code!=''){
                	MeterService.searchAllPulseByCodeRestrictionDate(self.meterChoose.code,self.startDatePulse, self.endDatePulse).then(function (data) {
                        self.listPulse = data.data;
                        console.log(self.listPulse);
                        console.log(data.data);
                        console.log("get successfull");
                }).catch(function () {
                        $scope.error = 'unable to get pulse';
                });
                	initData();
                }
                }
                function showAllPulseOfMeter(meterCode){
                	MeterService.searchAllPulseByCode(meterCode).then(function (data) {
                        self.listPulse = data.data;
                        console.log(self.listPulse);
                        console.log(data.data);
                        console.log("get successfull");
                }).catch(function () {
                        $scope.error = 'unable to get pulse';
                });
                }
                function showAllPulseOfMeterChart(){
                	showAllPulseOfMeter();
                	initData();
                }
                /////////////////////////soft by ts//////////////
                function softPulse(){
                        for(var i = 0 ; i < self.listPulse.length-1; i++)
                        for(var j =i; j < self.listPulse.length; j++)
                        if(self.listPulse[i].ts > self.listPulse[j].ts){
                                var temp = self.listPulse[i];
                                self.listPulse[i] = self.listPulse[j];
                                self.listPulse[j] = temp;
                        }
                }

                ///convert data from listPulse to data Chart//////////
                function convertData(){
                        if(self.listPulse!=null && self.listPulse.length >0)
                        {       
                                self.data=[];
                                self.category=[];
                                self.category[0] = self.listPulse[0].ts==undefined ? 'null': String(new Date(self.listPulse[0].ts));;
                                self.data[0] = self.listPulse[0].champsa; 
                        for(var i = 1 ; i < self.listPulse.length; i++){
                                self.data[i] = self.listPulse[i].champsa -self.listPulse[i-1].champsa;
                                self.category[i] = String(new Date(self.listPulse[i].ts));
//                                console.log(String(new Date(self.category[i])));

                                
                                }
                                console.log(self.data);
                                console.log(self.category);
                                Highcharts.chart('chart', {
                                        title: {
                                          text: 'Offset Champsa Meter Chart'
                                        },
                                  
                                        xAxis: {
                                          categories: self.category
                                          
                                        },
                                  
                                        series: [{
                                          type: 'column',
                                          data: self.data
                                        }]
                                    });
                        }

                        else {
                        	initDataChart();
                        	Highcharts.chart('chart', {
                                title: {
                                  text: 'Offset Champsa Meter Chart'
                                },
                          
                                xAxis: {
                                  categories: self.category
                                  
                                },
                          
                                series: [{
                                	type: 'column',
                                  data: self.data
                                }]
                            });
                        }
                        
                }
                function clickChartBtn(){
                	self.showChart = !self.showChart;
                	if(self.nameChart == "Show Chart") self.nameChart = "Detail Meter";
                	else
                	self.nameChart = "Show Chart";
                	initData();
                }
                function initData(){
                        softPulse();
                        convertData();
                }
   }
]);