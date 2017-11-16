package com.ifisolution.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.model.Meter;
import com.ifisolution.model.PulseTranform;
import com.ifisolution.service.MeterService;


@CrossOrigin(origins = { "*" })
@RestController
public class MeterController {
	public static final Logger logger = LoggerFactory.getLogger(MeterController.class);

	@Autowired
	MeterService meterService;

	/////////////// get All Meter/////////////////////

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
	
	/////////////// get Add Pulse/////////////////////
	@RequestMapping(value = "/meter/pulse", method = RequestMethod.GET)
	public ResponseEntity<List<PulseTranform>> getAllPulse() {
		logger.info("Fetch All Pulse");
		List<PulseTranform> listPulse= meterService.showAllPulse();
		if (listPulse.size() == 0 || listPulse == null) {
			logger.info("Not Content.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			logger.info("amount: " + listPulse.size());
		return new ResponseEntity<List<PulseTranform>>(listPulse, HttpStatus.OK);

	}
	
	
	//////////////////////////// create
	
	@RequestMapping(value = "/meter/add_meter/{partnerId}/{bucketId}/", method = RequestMethod.POST)
	public ResponseEntity<?> saveMeter(@RequestBody Meter meter, @PathVariable("partnerId") String partnerId,
			@PathVariable("bucketId") String bucketId) throws Exception {
		logger.info("Creatting :" + meter != null ? meter.toString()
				: "null" + "Bucket Id:" + bucketId + " partnerId: " + partnerId);
		if (meterService.findOne(meter, bucketId, partnerId) != null) {
			logger.info("meter is exit");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		if (bucketId == null || bucketId == "")
			throw new Exception("BucketId Can't null !");
		if (partnerId == null || partnerId == "")
			throw new Exception("partnerId Can't null !");
		if (meter == null)
			throw new Exception("Null Meter");
		meterService.saveMeter(meter, bucketId, partnerId);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	//////////////////////////// create

	@RequestMapping(value = "/meter/add_pulse/{partnerId}/{bucketId}/", method = RequestMethod.POST)
	public ResponseEntity<?> addPulse(@RequestBody Meter meter, @PathVariable("partnerId") String partnerId,
			@PathVariable("bucketId") String bucketId) throws Exception {
		logger.info("Creatting :" + meter != null ? meter.toString()
				: "null" + "Bucket Id:" + bucketId + " partnerId: " + partnerId);
		if (meterService.checkExitMeter(meter.getCode())) {
			logger.info("meter is exit");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		if (bucketId == null || bucketId == "")
			throw new Exception("BucketId Can't null !");
		if (partnerId == null || partnerId == "")
			throw new Exception("partnerId Can't null !");
		if (meter == null)
			throw new Exception("Null Meter");
		meterService.saveMeter(meter, bucketId, partnerId);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	//////////////////////////// search beween date

	@RequestMapping(value = "/meter/search/{startDate}/{endDate}/", method = RequestMethod.GET)
	public ResponseEntity<List<Meter>> searchMeter(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) throws Exception {
		logger.info("Searching  Date From :" + startDate + " To " + endDate);
		if (startDate == null || endDate == null) {
			logger.info("a date input was null");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (startDate.getTime() > endDate.getTime()) {
			logger.info("date start bigger date end");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Meter> listMeter = meterService.showMeterByBetweenDate(startDate, endDate);
		if (listMeter == null) {
			logger.info("not found query");
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		logger.info("record finded: " + listMeter.size());
		return new ResponseEntity<List<Meter>>(listMeter,HttpStatus.OK);
	}
	//////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/meter/pulse/addpulse/", method = RequestMethod.POST)
	public ResponseEntity<?> addPulse(@RequestBody PulseTranform pulseTranform)throws Exception {
		logger.info("Creatting :" + pulseTranform != null ? pulseTranform.toString()
				: "null");
		if (pulseTranform == null) {
			throw new Exception("Null Pulse Input");
		}
		if(pulseTranform.getChampsa() <0 ) {
			logger.info("champsa false");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(!meterService.checkExitMeter(pulseTranform.getModuleId())) {
			logger.info("NO Root meter");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		meterService.savePulse(pulseTranform);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	

}





























