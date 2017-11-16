<div id="body">
  <div class="left">
    <p>Meter list</p>
    <!-- <p> -->
   <div class="input-group">	
      <input type="date"size="15" ng-model='ctrl.startDate'/>
      <lable>-</label>
      <input type="date" size="15" ng-model='ctrl.endDate'/>
      <button type="button" ng-click='ctrl.searchByBeweenDate()'class="btn btn-info">Search	</button>
      <button type="button" ng-click='ctrl.loadAllMeter()' class="btn btn-info">All Meter</button>
      <p>{{ctrl.startDate}}</p>
  </div> 
  <ul>
    <li ng-repeat='u in ctrl.listMeter' ng-click="ctrl.showInfo(u)">CODE: {{u.code}} - METER: {{u.name}}</li>
  </ul>
  <div class="plus">
    <p>+</p>
  </div>
</div>
<div class="right">
  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
    <br>
    <div class="form-group">
      <label class="col-sm-2 control-label">Meter Code</label>
      <div class="col-sm-2">
        <input class="form-control" id="focusedInput" type="text" ng-model='ctrl.meter.code' placeholder="meter code">
      </div>
      <label class="col-sm-2 control-label">Meter Name</label>
      <div class="col-sm-2">
        <input class="form-control" id="focusedInput" type="text" ng-model='ctrl.meter.name' placeholder="meter Name">
      </div>
      <label class="col-sm-2 control-label">start Date</label>
      <div class="col-sm-2">
        <input class="form-control" id="focusedInput" type="Date" ng-model='ctrl.meter.startDate'>
      </div>
    </div>
    
    <br>

    <div class="input-group">
      <span class="checkbox">
        <label>
          <input type="checkbox" ng-model="ctrl.meter.status" ng-true-value="true" ng-false-value="false">Status</label>
      </span>

      <span class="checkbox">

        <label>
          <input type="checkbox" ng-model="ctrl.meter.meterType" ng-true-value="true" ng-false-value="false">Meter Type</label>
      </span>
    </div>
    <br>
    <div class="input-group">
      <label class="col-sm-2 control-label">Unit</label>
      <div class="col-sm-3">
      <select class="form-control" ng-model="ctrl.meter.unit ">
                <!-- "00: MWh 01: kWh 03: m3 04: Tonne 05: Kg " -->
                <option value='00'>MWh</option>
                <option value='01'>kWh</option>
                <option value='03'>m3</option>
                <option value='04'>Tonne</option>
                <option value='05'>Kg</option>
            </select>
            </div>
            <label class="col-sm-2 control-label">PCI conversion coefficient</label>
<div class="col-sm-3">
        <input class="form-control" id="focusedInput" placeholder="PCI" type="Number" ng-model="ctrl.meter.pci">
      </div>
        	<label class="col-sm-2 control-label">PCI conversion coefficient</label>
      <div class="col-sm-3">
        <input class="form-control" id="focusedInput" placeholder="PCS" type="Number" ng-model="ctrl.meter.pcs">
      </div>
        </div>
        </br>        
        	                <div class="row ">
	                    <div class="form-actions floatRight ">
                          <button type="button" ng-click="ctrl.reset() " class="btn btn-warning btn-sm " ng-disabled="myForm.$pristine ">Cancel</button>
	                        <button type="button" ng-click="ctrl.reset() " class="btn btn-warning btn-sm " ng-disabled="myForm.$pristine ">Reset</button>
	                        <input type="submit"  value="Save " class="btn btn-primary btn-sm ">
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
    </form>
    <div>

</div>


</div>