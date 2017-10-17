package com.chen.quartz.cronTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {
	public static void main(String[] args) throws Exception {

		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("dummyJobName", "group1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("1,0/5 * * ? * tue")).build();

		//cronSchedule("* * 8,10,14,16 * * ?")
		//		
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}
