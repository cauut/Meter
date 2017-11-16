package com.ifisolution.model;


import java.io.Serializable;
import java.util.Map;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;

@Table("object")
public class Object implements Serializable{
	@PrimaryKey
	private ObjectKey key;
	private Map<String, String> field ;
	private String objectName;
	private String objectType;
	
	public Object(ObjectKey key, Map<String, String> field, String objectName, String objectType) {
		super();
		this.key = key;
		this.field = field;
		this.objectName = objectName;
		this.objectType = objectType;
	}
	public Object() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjectKey getKey() {
		return key;
	}
	public void setKey(ObjectKey key) {
		this.key = key;
	}
//	@Column(value="field")
//	@CassandraType(type=Name.MAP)
	public Map<String, String> getField() {
		return field;
	}
	public void setField(Map<String, String> field) {
		this.field = field;
	}
	@Column(value="object_name")
	@CassandraType(type=Name.TEXT)
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	@Column(value="object_type")
	@CassandraType(type=Name.ASCII)
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
}
