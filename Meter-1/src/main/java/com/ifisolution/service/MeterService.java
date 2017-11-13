package com.ifisolution.service;

import java.util.Date;
import java.util.List;

import com.ifisolution.model.Meter;
import com.ifisolution.model.Pulse;



public interface MeterService {
	public void saveMeter(Meter meter, String bucketId, String partnerId) throws Exception;
	public void saveMeter(List<Meter> listMeter, String bucketId, String partnerId) throws Exception;
	public List<Meter> showAllMeter();
	public List<Pulse> showAllPulse();
	public List<Meter> showMeterByBetweenDate(Date startDate, Date endDate);
	public Meter findOne(Meter meter, String bucketid, String partnerId);
//	public void deleteMeter(Meter)
}
