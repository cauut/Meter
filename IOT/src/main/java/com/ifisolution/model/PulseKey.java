package com.ifisolution.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.DataType.Name;
@PrimaryKeyClass
public class PulseKey implements Serializable {
	private String moduleId;
	private Integer bucketTs;
	private Date ts;
	
	@PrimaryKeyColumn(name = "module_id", type = PrimaryKeyType.PARTITIONED)
	@CassandraType(type = Name.ASCII)
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	@PrimaryKeyColumn(name = "bucket_ts", type = PrimaryKeyType.PARTITIONED)
	@CassandraType(type = Name.BIGINT)
	public Integer getBucketTs() {
		return bucketTs;
	}
	public void setBucketTs(Integer bucketTs) {
		this.bucketTs = bucketTs;
	}
	
	@PrimaryKeyColumn(name = "ts", type = PrimaryKeyType.CLUSTERED, ordering=Ordering.DESCENDING)
	@CassandraType(type = Name.TIMESTAMP)
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public PulseKey(String moduleId, Integer bucketTs, Date ts) {
		super();
		this.moduleId = moduleId;
		this.bucketTs = bucketTs;
		this.ts = ts;
	}
	public PulseKey() {
		super();
		// TODO Auto-generated constructor stub
	}
}
