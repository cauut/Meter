<!DOCTYPE html>

<html lang="en" ng-app='IOT'>

<head>
    <title>${title}</title>
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/app.css" rel="stylesheet" />
    <link href="css/right.css" rel="stylesheet" />
</head>

<body>



<div ui-view></div> 
    

    <script src="js/lib/angular.min.js"></script>
    <script src="js/lib/angular-ui-router.min.js"></script>
    <script src="js/lib/localforage.min.js"></script>
    <script src="js/lib/ngStorage.min.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/MeterService.js"></script>
    <script src="js/app/MeterController.js"></script>
    <script src="js/app/home.controller.js"></script>
  <!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
    <script src="js/lib/ui-bootstrap-tpls-2.0.0.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    
</body>

</html>