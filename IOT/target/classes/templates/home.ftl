<div id="body">
  <div class="left">
    <h3>Meter list</h3>

    <div class="input-group">
      <input type="date" size="15" ng-model='ctrl.startDate' />
      <lable>-</label>
        <input type="date" size="15" ng-model='ctrl.endDate' />
    </div>
    <div class="input-group">
      <button type="button" ng-click='ctrl.searchByBeweenDate()' class="btn btn-info" size="15px">Search</button>
      <button type="button" ng-click='ctrl.loadAllMeter()' class="btn btn-info">All Meter</button>
    </div>
    <ul>
      <li ng-repeat='u in ctrl.listMeter' ng-click="ctrl.showInfo(u)">
        <button type="button" id='tbl-list' class="btn btn-default">
          <span class='tbn-list'>CODE: {{u.code}} - METER: {{u.name}}</span>
        </button>
      </li>
    </ul>
    <div class="row ">
      <div class="form-actions floatRight">
        <button type="button" ng-click="ctrl.showForm() " class="btn btn-success">Add Meter</button>
      </div>
      <button ng-click="openModal()"></button>
    </div>
  </div>
  <div class="right">
    <div>
    <form ng-submit="ctrl.submit()" name="myForm" class="form-inline" >
     
      <div class="form-group">
        <label>Meter Code</label>
        <div>
          <input class="form-control" id="focusedInput" type="text" ng-model='ctrl.meter.code' placeholder="meter code">
        </div>
      </div>
      <div class='form-group'>
        <label>Meter Name</label>
        <div>
          <input class="form-control" id="focusedInput" type="text" ng-model='ctrl.meter.name' placeholder="meter Name">
        </div>
      </div>
      <div class='form-group'>
        <label>start Date</label>
        <div>
          <input class="form-control" id="focusedInput" type="Date" ng-model='ctrl.meter.startDate'>
        </div>
      </div>

     <div class="form-group">
        <label>Unit</label>
        <div>
          <select class="form-control" ng-model="ctrl.meter.unit ">
            <!-- "00: MWh 01: kWh 03: m3 04: Tonne 05: Kg " -->
            <option value='00'>MWh</option>
            <option value='01'>kWh</option>
            <option value='03'>m3</option>
            <option value='04'>Tonne</option>
            <option value='05'>Kg</option>
          </select>
        </div>
      </div>
      <div class='form-group'>
        <label>PCI conversion coefficient</label>
        <div>
          <input class="form-control" id="focusedInput" placeholder="PCI" type="Number" ng-model="ctrl.meter.pci">
        </div>
      </div>
      <div class='form-group'>
        <label>PCI conversion coefficient</label>
        <div>
          <input class="form-control" id="focusedInput" placeholder="PCS" type="Number" ng-model="ctrl.meter.pcs">
        </div>
      </div>
      
      <br>

      <div class="form-group">
        <span class="checkbox">
          <label>
            <label>PCI conversion coefficient</label>
            <input type="checkbox" ng-model="ctrl.meter.status" ng-true-value="true" ng-false-value="false">Status</label>
        </span>
      </div>
      <div class="form-group">
        <span class="checkbox">

          <label>
            <input type="checkbox" ng-model="ctrl.meter.meterType" ng-true-value="true" ng-false-value="false">Meter Type</label>
        </span>
      </div>
    
     
      </br>
      <div class="row ">
        <div class="form-actions floatRight ">
          <button type="button" ng-click="ctrl.reset() " class="btn btn-warning btn-sm " ng-disabled="myForm.$pristine ">Cancel</button>
          <button type="button" ng-click="ctrl.reset() " class="btn btn-warning btn-sm " ng-disabled="myForm.$pristine ">Reset</button>
          <input type="submit" value="Save " class="btn btn-primary btn-sm ">
        </div>
    </form>
  </div>
    <br>
    <div class="container">
    <div class="form-actions floatRight">
        
      </div>
      <div class="alert alert-success">
        <h4>Thông tin cơ bản của Meter</h4>
      </div>
      <div class="alert alert-info">
        <strong>Code Meter: {{ctrl.meterChoose.code}}</strong>
        <strong>Name Meter: {{ctrl.meterChoose.name}}</strong>
        <strong>Start Date: {{ctrl.meterChoose.startDate|date}}</strong>
      </div>
      <div class="alert alert-success">
        <strong ng-if="ctrl.meterChoose.unit=='00'">Unit: KWh </strong>
        <strong ng-if="ctrl.meterChoose.unit=='01'">Unit: MWH </strong>
        <strong ng-if="ctrl.meterChoose.unit=='02'">Unit: KWh </strong>
        <strong ng-if="ctrl.meterChoose.unit=='03'">Unit: m3 </strong>
        <strong ng-if="ctrl.meterChoose.unit=='04'">Unit: tonne </strong>
        <strong ng-if="ctrl.meterChoose.unit=='05'">Unit: Kg </strong>
        <strong>PCI conversion coefficient: {{ctrl.meterChoose.pci}}</strong>
        <strong>PCS conversion coefficient : {{ctrl.meterChoose.pcs}}</strong>
      </div>
      <ul>
        <div div class="alert alert-success" ng-repeat='pulse in ctrl.listPulse'> Code: {{pulse.moduleId}} bucket Time Stamp: {{pulse.bucket_ts}}- Time: {{pulse.ts|date}} - Champsa: {{pulse.champsa}}</li>
      </ul>
      </div>
      <div id='chart'>placeholder for chart</div>
      <div class="input-group">
      <input type="date" size="15" ng-model='ctrl.startDatePulse' />
      <lable>-</label>
        <input type="date" size="15" ng-model='ctrl.endDatePulse' />
    </div>
    <div class="input-group">
    <button type="button" ng-click="ctrl.initData() " class="btn btn-success">InitData</button>
      <button type="button" ng-click='ctrl.searchPulseRestrictDate()' class="btn btn-info" size="15px">Search</button>
      <button type="button" ng-click='ctrl.showAllPulseOfMeter()' class="btn btn-info">All Pulse Of Meter</button>
    </div>
    </div>
  </div>
</div>