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
public class ObjectKey implements Serializable {

	private String partnerId;

	private String bucketId;

	private String objectCode;

	private Date startDate;

	public ObjectKey(String partnerId, String bucketId, String objectCode, Date startDate) {
		super();
		this.partnerId = partnerId;
		this.bucketId = bucketId;
		this.objectCode = objectCode;
		this.startDate = startDate;
	}

	public ObjectKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PrimaryKeyColumn(name = "partner_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@CassandraType(type = Name.ASCII)
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@PrimaryKeyColumn(name = "bucket_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	@CassandraType(type = Name.ASCII)
	public String getBucketId() {
		return bucketId;
	}

	public void setBucketId(String bucketId) {
		this.bucketId = bucketId;
	}

	@PrimaryKeyColumn(name = "object_code", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	@CassandraType(type = Name.ASCII)
	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	@PrimaryKeyColumn(name = "start_date", ordinal = 3, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	@CassandraType(type = Name.TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
