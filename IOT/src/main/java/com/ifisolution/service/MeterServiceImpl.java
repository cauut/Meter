package com.ifisolution.service;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ifisolution.map.MeterMapper;
import com.ifisolution.model.Meter;
import com.ifisolution.model.Object;
import com.ifisolution.model.Pulse;
import com.ifisolution.model.PulseTranform;
import com.ifisolution.repository.ObjectRepository;
import com.ifisolution.repository.PulseRepository;
import com.ifisolution.util.Value;



@Service("meterService")
public class MeterServiceImpl implements MeterService {
	public static final Logger logger = LoggerFactory.getLogger(MeterServiceImpl.class);
	@Autowired
	PulseRepository pulseRepository;
	@Autowired
	ObjectRepository objectRepository;
	MeterMapper mapper;

	public MeterServiceImpl() {
		super();
		mapper = new MeterMapper();
	}

	/// save meter
	@Override
	public void saveMeter(Meter meter, String bucketId, String partnerId) throws Exception {

		Object object = mapper.toObjectPulseFromMeter(meter, partnerId, bucketId);
		objectRepository.save(object);

		Pulse pulse = mapper.toPulseFromObject(object);
		pulseRepository.save(pulse);

	}

	@Override
	public void saveMeter(List<Meter> listMeter, String bucketId, String partnerId) throws Exception {
		// TODO Auto-generated method stub
		if (bucketId == null || bucketId == "")
			throw new Exception("BucketId Can't null !");
		if (partnerId == null || partnerId == "")
			throw new Exception("partnerId Can't null !");

		List<Object> listObject = mapper.toObjectPulseFromMeter(listMeter, partnerId, bucketId);
		List<Pulse> listPulse = mapper.toPulseFromObject(listObject);

		

	}

	@Override
	public List<Meter> showAllMeter() {
		// TODO Auto-generated method stub
		List<Object> listObject = Lists.newArrayList(objectRepository.findAll());
		return mapper.toMeterFromObject(listObject);
	}

	@Override
	public List<PulseTranform> showAllPulse() {
		// TODO Auto-generated method stub
		return mapper.toPulseTranformFromPulse(Lists.newArrayList(pulseRepository.findAll()));
	}

	@Override
	public List<Meter> showMeterByBetweenDate(Date startDate, Date endDate) {
		List<Object> listObject = Lists
				.newArrayList(objectRepository.findByBetweenStartDate(startDate, endDate));
		return mapper.toMeterFromObject(listObject);
		// return null;
	}

	// find one
	@Override
	public Meter findOne(Meter meter, String bucketid, String partnerId) {
		// TODO Auto-generated method stub
		logger.info("Error here");
		BasicMapId id = new BasicMapId();
		id.put(Value.MAPID_OBJECT.objectCode.toString(), meter.getCode());
		id.put(Value.MAPID_OBJECT.startDate.toString(), meter.getStartDate());
		id.put(Value.MAPID_OBJECT.bucketId.toString(), bucketid);
		id.put(Value.MAPID_OBJECT.partnerId.toString(), partnerId);
		Object object = objectRepository.findOne(id);
		if (object == null)
			return null;
		else
			return mapper.toMeterFromObject(object);
	}

	@Override
	public boolean checkExitMeter(String meterCode) {
		List<Pulse> listPulse = Lists
				.newArrayList(pulseRepository.searchPulseByModuleId(meterCode, 0, Integer.MAX_VALUE));
		System.out.println(listPulse.size());
		if (listPulse == null || listPulse.isEmpty())
			return false;
		return true;
		
	}

	@Override
	public void savePulse(PulseTranform pulseTranForm) {
		Pulse pulse = new Pulse();
		pulse = mapper.toPulseFormPulseTranform(pulseTranForm);
		pulseRepository.save(pulse);
	}

	@Override
	public void savePulse(List<PulseTranform> listPulseTranform) {
		List<Pulse> listPulse = mapper.toPulseFormPulseTranform(listPulseTranform);
		pulseRepository.save(listPulse);

	}

	@Override
	public List<PulseTranform> findPulseTranFormByCode(String code) {
		// TODO Auto-generated method stub
		Iterable<Pulse> iterPulse = pulseRepository.searchPulseByModuleId(code, 0, Integer.MAX_VALUE);
		List<PulseTranform> listPulseTranform = mapper.toPulseTranformFromPulse(Lists.newArrayList(iterPulse));
		return listPulseTranform;
	}

	@Override
	public List<PulseTranform> findPulseTranFormByCodeRestrictionDate(String code, Date startDate, Date endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(Value.FORMAT_DATE_ID);
		Integer startDateId = Integer.parseInt(formatter.format(startDate));
		Integer endDateId = Integer.parseInt(formatter.format(endDate));
		Iterable<Pulse> iterPulse = pulseRepository.searchPulseByDateBetween(code, startDateId, endDateId, startDate,
				endDate);
		List<PulseTranform> listPulseTranform = mapper.toPulseTranformFromPulse(Lists.newArrayList(iterPulse));
		return listPulseTranform;
	}

}
