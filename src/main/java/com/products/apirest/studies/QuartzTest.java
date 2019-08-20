//package com.products.apirest.studies;
//import static org.quartz.CronScheduleBuilder.cronSchedule;
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.TriggerBuilder.newTrigger;
//
//import org.quartz.CronTrigger;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//  public class QuartzTest implements CommandLineRunner{
//
//
//	@Override
//	public void run(String... args) throws Exception {
//        try {
//            // Grab the Scheduler instance from the Factory
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//            // and start it off
//            scheduler.start();
//
//            JobDetail job = newJob(MyJob.class)
//          	      .withIdentity("job1", "group1")
//          	      .build();
//
//          	  // Trigger the job to run now, and then repeat every 40 seconds
//            CronTrigger trigger = newTrigger()
//          		    .withIdentity("trigger1", "group1")
//          		    .withSchedule(cronSchedule("34 1-3 * * * ?"))
//          		    .build();
//
//            scheduler.scheduleJob(job, trigger);
//
//          	 
//        } catch (SchedulerException se) {
//            se.printStackTrace();
//        
//		
//	}
//  }
//}