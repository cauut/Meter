package com.ifisolution.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.model.Meter;
import com.ifisolution.service.MeterService;



@RestController
public class MeterController {
	public static final Logger logger = LoggerFactory.getLogger(MeterController.class);
	@Autowired
	MeterService meterService;

	//get All Meter

	@RequestMapping(value = "/meter", method = RequestMethod.GET)
	public ResponseEntity<List<Meter>> getAllMeter() {
		logger.info("Fetch All meter...............");
		List<Meter> listMeter = meterService.showAllMeter();
		if (listMeter.size() == 0 || listMeter == null) {
			logger.info("Not Content.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			logger.info("amount: " + listMeter.size());
		return new ResponseEntity<List<Meter>>(listMeter, HttpStatus.OK);

	}
   //create
	@RequestMapping(value = "/meter/add_meter/{partnerId}/{bucketId}/", method = RequestMethod.POST)
	public ResponseEntity<?> saveMeter(@RequestBody Meter meter, @PathVariable("partnerId") String partnerId,
			@PathVariable("bucketId") String bucketId) throws Exception {
		logger.info("Creatting :" +meter!=null? meter.toString(): "null" + "Bucket Id:" + bucketId + " partnerId: "  + partnerId);
		if(meterService.findOne(meter, bucketId, partnerId)!=null) {
			logger.info("meter is exit");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		if (bucketId == null || bucketId == "")
			throw new Exception("BucketId Can't null !");
		if (partnerId == null || partnerId == "")
			throw new Exception("partnerId Can't null !");
		if(meter==null) throw new Exception("Null Meter");
		meterService.saveMeter(meter, bucketId, partnerId);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
