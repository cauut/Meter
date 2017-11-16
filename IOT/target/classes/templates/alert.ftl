<div class="modal-content">
    <div class="modal-header">
       <button type="button" class="close" ng-click="cancel()" aria-hidden="true">×</button>
       <h4 class="modal-title custom_align" id="Heading">{{ data.title }}</h4>
    </div>
    <div class="modal-body">
        <div class="alert alert-warning"><span class="fa fa-warning"></span> {{ data.message }}</div>
    </div>
    <div class="modal-footer ">
         <button type="button" class="btn btn-warning" ng-click="ok()">OK</button>
         <button type="button" class="btn btn-warning" ng-click="cancel()">Cancel</button>
    </div>
</div>
<!-- /.modal-content -->