package com.ifisolution.model;

import java.io.Serializable;
import java.util.Date;

public class PulseTranform implements Serializable{
	private String moduleId;
	private Integer bucket_ts;
	private Date ts;
	private Float champsa;
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Integer getBucket_ts() {
		return bucket_ts;
	}
	public void setBucket_ts(Integer bucket_ts) {
		this.bucket_ts = bucket_ts;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Float getChampsa() {
		return champsa;
	}
	public void setChampsa(Float champsa) {
		this.champsa = champsa;
	}
	public PulseTranform() {
		super();
	}
	public PulseTranform(String moduleId, Integer bucket_ts, Date ts, Float champsa) {
		super();
		this.moduleId = moduleId;
		this.bucket_ts = bucket_ts;
		this.ts = ts;
		this.champsa = champsa;
	}
	@Override
	public String toString() {
		return "PulseTranform [moduleId=" + moduleId + ", bucket_ts=" + bucket_ts + ", ts=" + ts + ", champsa="
				+ champsa + "]";
	}
	

}
