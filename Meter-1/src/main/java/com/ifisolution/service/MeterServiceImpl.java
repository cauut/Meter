package com.ifisolution.service;

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
import com.ifisolution.model.Pulse;
import com.ifisolution.model.Object;
import com.ifisolution.repository.ObjectRepository;
import com.ifisolution.repository.PulseRepository;
import com.ifisolution.util.Value;


@Service("meterService")
public class MeterServiceImpl implements MeterService{
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
	
	// save meter
	@Override
	public void saveMeter(Meter meter, String bucketId, String partnerId) throws Exception{
		
		Object object = mapper.toObjectPulseFromMeter(meter, partnerId, bucketId);
		objectRepository.save(object);
		
		Pulse pulse = mapper.toPulseFromObject(object);
		pulseRepository.save(pulse);
		
	}
	@Override
	public void saveMeter(List<Meter> listMeter, String bucketId, String partnerId) throws Exception{
		// TODO Auto-generated method stub
		if(bucketId==null || bucketId=="") throw new Exception("BucketId Can't null !");
		if(partnerId==null || partnerId=="") throw new Exception("partnerId Can't null !");
		
		List<Object> listObject = mapper.toObjectPulseFromMeter(listMeter, partnerId, bucketId);
		List<Pulse> listPulse = mapper.toPulseFromObject(listObject);
		
//		objectRepositories.save(listObject);
//		pulseRepositories.save(listPulse);
		
		
	}
	@Override
	public List<Meter> showAllMeter() {
		// TODO Auto-generated method stub
		List<Object> listObject = Lists.newArrayList(objectRepository.findAll());
		return mapper.toMeterFromObject(listObject);
	}
	@Override
	public List<Pulse> showAllPulse() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(pulseRepository.findAll());
	}
	@Override
	public List<Meter> showMeterByBetweenDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
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
		if(object==null) return null;
		else
		return mapper.toMeterFromObject(object);
	}
	
	
}
//