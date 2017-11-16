package com.ifisolution.map;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifisolution.model.Meter;
import com.ifisolution.model.Object;
import com.ifisolution.model.ObjectKey;
import com.ifisolution.model.Pulse;
import com.ifisolution.model.PulseKey;
import com.ifisolution.model.PulseTranform;
import com.ifisolution.util.Value;



public class MeterMapper {
	public static final Logger logger = LoggerFactory.getLogger(MeterMapper.class);

	//convert Object to meter
	public Meter toMeterFromObject(Object object) {
		Meter meter = new Meter();
		meter.setCode(object.getKey().getObjectCode());
		meter.setName(object.getObjectName());
		meter.setMeterType(object.getObjectType());
		meter.setPCI(Float.parseFloat(object.getField().get(Value.VALUE_METER.PCI.toString())));
		meter.setPCS(Float.parseFloat(object.getField().get(Value.VALUE_METER.PCS.toString())));
		meter.setStatus(
				object.getField().get(Value.VALUE_METER.STATUS.toString()).equalsIgnoreCase("true") ? true : false);
		meter.setUnit(object.getField().get(Value.VALUE_METER.UNIT.toString()));
		meter.setStartDate(object.getKey().getStartDate());

		return meter;
	}

	// convert Pulse from object
	public Pulse toPulseFromObject(Object object) {
		Pulse pulse = new Pulse();
		SimpleDateFormat formatter = new SimpleDateFormat(Value.FORMAT_DATE_ID);
		Integer moduleId = null;
		Date date = object.getKey().getStartDate();

		moduleId = Integer.parseInt(formatter.format(date));
		PulseKey pulseId = new PulseKey();
		pulseId.setModuleId(object.getKey().getObjectCode());
		pulseId.setBucketTs(moduleId);
		pulseId.setTs(date);

		pulse.setPk(pulseId);
		pulse.setChampsa(object.getKey().getObjectCode());
		pulse.setChampsa("0");
		return pulse;
	}

	//convert object from meter
	public Object toObjectPulseFromMeter(Meter meter, String partnerId, String bucketId) throws Exception {
		Object object = new Object();
		if (meter.getCode() == null)
			throw new Exception("Code Meter Can't null");
		if (meter.getStartDate() == null)
			throw new Exception("Start Date Can't null !");
		// process date id
		ObjectKey id = new ObjectKey();
		id.setBucketId(bucketId);
		id.setObjectCode(meter.getCode());
		id.setPartnerId(partnerId);
		id.setStartDate(meter.getStartDate());

		// init map
		Map<String, String> field = new HashMap<String, String>();
		field.put(Value.VALUE_METER.UNIT.toString(), meter.getUnit());
		field.put(Value.VALUE_METER.METERTYPE.toString(), meter.getMeterType());
		field.put(Value.VALUE_METER.PCI.toString(), String.valueOf(meter.getPCI()));
		field.put(Value.VALUE_METER.PCS.toString(), String.valueOf(meter.getPCS()));
		field.put(Value.VALUE_METER.STATUS.toString(), String.valueOf(meter.isStatus()));
		SimpleDateFormat formatter = new SimpleDateFormat(Value.FORMAT_DATE);

		// insert data for ObjectPulse
		object.setField(field);
		object.setKey(id);
		object.setObjectName(meter.getName());
		object.setObjectType(meter.getMeterType());
		return object;
	}

	// convert List

	/// _______________List Meter_____________________________________
	public List<Meter> toMeterFromObject(List<Object> objectPulseList) {
		List<Meter> meterList = new ArrayList<Meter>();
		for (Object objectPulse : objectPulseList) {
			Meter meter = toMeterFromObject(objectPulse);
			meterList.add(meter);
		}
		return meterList;
	}

	// _________________List Pulse___________________////////////
	public List<Pulse> toPulseFromObject(List<Object> objectList) {
		List<Pulse> pulseList = new ArrayList<Pulse>();
		for (Object object : objectList) {
			Pulse pulse = toPulseFromObject(object);
		}
		return pulseList;
	}

	// list Object Pulse
	public List<Object> toObjectPulseFromMeter(List<Meter> meterList, String partnerId, String bucketId)
			throws Exception {
		List<Object> objectList = new ArrayList<Object>();
		for (Meter meter : meterList) {
			Object objectPulse = toObjectPulseFromMeter(meter, partnerId, bucketId);
			objectList.add(objectPulse);
		}
		return objectList;
	}
	
	// map pulse
	
	public Pulse toPulseFormPulseTranform(PulseTranform pulseTranform) {
		Pulse pulse = new Pulse();
		PulseKey id = new PulseKey();
		id.setBucketTs(pulseTranform.getBucket_ts());
		id.setModuleId(pulseTranform.getModuleId());
		id.setTs(pulseTranform.getTs());
		pulse.setPk(id);
		pulse.setChampsa(String.valueOf(pulseTranform.getChampsa()));
		return pulse;
	}
	public PulseTranform toPulseTranformFromPulse(Pulse pulse) {
		PulseTranform pulseTranform = new PulseTranform();
		pulseTranform.setBucket_ts(pulse.getPk().getBucketTs());
		pulseTranform.setChampsa(Float.parseFloat(pulse.getChampsa()));
		pulseTranform.setModuleId(pulse.getPk().getModuleId());
		pulseTranform.setTs(pulse.getPk().getTs());
		return pulseTranform;
	}
	
	// convert list
	
	public List<Pulse> toPulseFormPulseTranform(List<PulseTranform> listPulseTranform ){
		List<Pulse> listPulse = new ArrayList<Pulse>();
		for(PulseTranform pulseTranform : listPulseTranform) {
			Pulse pulse = new Pulse();
			pulse = toPulseFormPulseTranform(pulseTranform);
			listPulse.add(pulse);
		}
		return listPulse;
	}
	
	public List<PulseTranform> toPulseTranformFromPulse(List<Pulse> listPulse) {
		List<PulseTranform> listPulseTranform = new ArrayList<PulseTranform>();
		for(Pulse pulse: listPulse) {
			PulseTranform pulseTranform = new PulseTranform();
			pulseTranform = toPulseTranformFromPulse(pulse);
			listPulseTranform.add(pulseTranform);
		}
		return listPulseTranform;
	}
	
	

}

































