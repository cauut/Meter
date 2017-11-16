package com.ifisolution.model;





import java.io.Serializable;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;


@Table(value="pulse")
public class Pulse implements Serializable{
	private PulseKey pk;
	private String champsa;
   @PrimaryKey
	public PulseKey getPk() {
		return pk;
	}

	public void setPk(PulseKey pk) {
		this.pk = pk;
	}
	@Column(value="champsa")
	@CassandraType(type=Name.ASCII)
	public String getChampsa() {
		return champsa;
	}

	public void setChampsa(String champsa) {
		this.champsa = champsa;
	}

	public Pulse(PulseKey pk, String champsa) {
		super();
		this.pk = pk;
		this.champsa = champsa;
	}

	public Pulse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
