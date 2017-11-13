package com.ifisolution.repository;



import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.model.Pulse;
@Repository
public interface PulseRepository  extends CassandraRepository<Pulse>{

	

}
