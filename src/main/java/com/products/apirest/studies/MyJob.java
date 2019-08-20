package com.products.apirest.studies;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.apirest.persistence.SpringJPAUtil;
import com.products.apirest.model.SchedulerUpdate;
import com.products.apirest.repository.SchedulerUpdateRepository;

@Service
public class MyJob implements Job{
	
	SchedulerUpdate schedulerUpdate;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Calendar cal = Calendar.getInstance();	
		
		String content = "HORA DE EXECUÇÃO: "+ 
								cal.get(Calendar.HOUR_OF_DAY)+":"
								+cal.get(Calendar.MINUTE)+":"
								+cal.get(Calendar.SECOND);
		
		System.out.println(content);
		
		
	}

	
	

}
