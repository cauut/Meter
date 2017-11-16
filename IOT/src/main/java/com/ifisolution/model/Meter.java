package com.ifisolution.model;

import java.io.Serializable;
import java.util.Date;

public class Meter implements Serializable{
	private String code;
	private String name;
	private boolean status;
	private String unit;
	private String meterType;
	private Float PCI;
	private Float PCS;
	@Override
	public String toString() {
		return "Meter [code=" + code + ", name=" + name + ", status=" + status + ", unit=" + unit + ", meterType="
				+ meterType + ", PCI=" + PCI + ", PCS=" + PCS + ", startDate=" + startDate + "]";
	}
	private Date startDate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public Float getPCI() {
		return PCI;
	}
	public void setPCI(Float pCI) {
		PCI = pCI;
	}
	public Float getPCS() {
		return PCS;
	}
	public void setPCS(Float pCS) {
		PCS = pCS;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Meter(String code, String name, boolean status, String unit, String meterType, Float pCI, Float pCS,
			Date startDate) {
		super();
		this.code = code;
		this.name = name;
		this.status = status;
		this.unit = unit;
		this.meterType = meterType;
		PCI = pCI;
		PCS = pCS;
		this.startDate = startDate;
	}
	public Meter() {
		super();
		// TODO Auto-generated constructor stub
	}
}
