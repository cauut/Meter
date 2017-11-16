package com.ifisolution.repository;



import java.util.Date;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


import com.ifisolution.model.Pulse;




public interface PulseRepository  extends CassandraRepository<Pulse>{

//search pulse 
@Query("SELECT * FROM pulse WHERE token(module_id,bucket_ts) >= token(?0, ?1) AND token(module_id,bucket_ts) <= token(?0,?2)")
Iterable<Pulse> searchPulseByModuleId(String moduleId, Integer bucketLow, Integer bucketHight);
//search by id and date restrition
@Query("SELECT * FROM pulse WHERE token(module_id,bucket_ts) >= token(?0, ?1) AND token(module_id,bucket_ts) <= token(?0,?2) AND ts >= ?3 AND ts <= ?4 ALLOW FILTERING")
Iterable<Pulse> searchPulseByDateBetween(String moduleId, Integer bucketLow, Integer bucketHight, Date startDate, Date endDate);
}
