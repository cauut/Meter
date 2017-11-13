package com.ifisoluton.main;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.ifisolution.configuration.CassandraConfiguration;
import com.ifisolution.model.Meter;

import com.ifisolution.service.MeterService;




@SpringBootApplication(scanBasePackages={"com.ifisolution.main"})
@EnableCassandraRepositories("com.ifisolution.repository")
@EntityScan("com.ifisolution.model")
@Import(CassandraConfiguration.class)
public class Meter1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Meter1Application.class, args);
	}
//	@Autowired
//	private MeterService meterService;
//	@Override
//	public void run(String... arg0) throws Exception {
//		Meter meter = new Meter();
//		meter.setCode("1");
//		meter.setMeterType("Cay");
//		meter.setName("Nhi anh");
//		meter.setPCI(1f);
//		meter.setPCS(2f);
//		meter.setStatus(true);
//		meter.setUnit("MG");
//		meter.setStartDate(new Date());
//		meterService.saveMeter(meter, "bucketId", "partnerId");
//		config();
//	}
//	@Autowired
//	private MeterService service;
//	PulseRepository pulseRepository;
//	@Autowired
//	ObjectRepository objectRepository;
//	public void config() {
//		
////	pulseRepository.save(new Pulse(new PulseKey("Nhat thien an",1234,new Date()),"chamsap"));
////	objectRepository.save(new Object(new ObjectKey("001","aa","arur",new Date()),null,"sd","ss"));
//	
//		Meter meter = new Meter();
//		meter.setCode("1");
//		meter.setMeterType("Chua Thay");
//		meter.setName("Dau khi");
//		meter.setPCI(1f);
//		meter.setPCS(2f);
//		meter.setStatus(true);
//		meter.setUnit("kg");
//		meter.setStartDate(new Date());
//		service.saveMeter(meter, "bucketId", "partnerId");
//		
//	}
}
