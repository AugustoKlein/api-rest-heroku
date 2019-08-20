package com.products.apirest;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import com.product.apirest.persistence.SpringJPAEntityMangerFactory;
import com.products.apirest.studies.MyJob;

@ServletComponentScan
@SpringBootApplication
public class ApirestApplication {
	static Class<?>[] componetsApplications = {ApirestApplication.class};
	
	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
		
	}

}