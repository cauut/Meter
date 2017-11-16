package com.ifisolution.IOT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.ifisolution.configuration.CassandraConfiguration;






@SpringBootApplication(scanBasePackages={"com.ifisolution.IOT"})
@EnableCassandraRepositories("com.ifisolution.repository")
@EntityScan("com.ifisolution.model")
@Import(CassandraConfiguration.class)
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
