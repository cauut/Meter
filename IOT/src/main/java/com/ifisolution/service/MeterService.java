package com.ifisolution.service;

import java.util.Date;
import java.util.List;

import com.ifisolution.model.Meter;
import com.ifisolution.model.PulseTranform;

public interface MeterService {

	public void saveMeter(Meter meter, String bucketId, String partnerId) throws Exception;
	public void saveMeter(List<Meter> listMeter, String bucketId, String partnerId) throws Exception;
	public List<Meter> showAllMeter();
	public List<PulseTranform> showAllPulse();
	public List<Meter> showMeterByBetweenDate(Date startDate, Date endDate);
	public Meter findOne(Meter meter, String bucketid, String partnerId);
	public List<PulseTranform> findPulseTranFormByCode(String code);
	public List<PulseTranform> findPulseTranFormByCodeRestrictionDate(String code, Date startDate, Date endDate);
	public boolean checkExitMeter(String meterCode);
	public void savePulse(PulseTranform pulseTramFrom);
	public void savePulse(List<PulseTranform> pulseTramFrom);

}