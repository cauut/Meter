package com.ifisolution.repository;

import java.util.Date;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


import com.ifisolution.model.Object;




public interface ObjectRepository extends CassandraRepository<Object> {

	@Query("SELECT * FROM object WHERE object_code = ?2 AND start_date >= ?0 AND start_date <= ?1 ALLOW FILTERING")
	Iterable<Object> findByBetweenStartDate( Date startDate, Date endDate, String objectCode);
	
	@Query("SELECT * FROM object WHERE start_date >= ?0 AND start_date <= ?1 ALLOW FILTERING")
	Iterable<Object> findByBetweenStartDate( Date startDate, Date endDate);
	
	@Query("SELECT * FROM object WHERE partner_id= ?0 AND bucket_id=?1 AND start_date >?2 AND object_code=?3 ")
	Object findOneWithoutDate(String partnerId, String bucket_id, Date startDate, String codeObject);
}
