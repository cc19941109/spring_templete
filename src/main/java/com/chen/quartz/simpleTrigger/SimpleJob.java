package com.chen.quartz.simpleTrigger;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleJob implements Job {

	public static void main(String[] args) {
		try {

			JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jgroup1").build();
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1_1", "tgroup1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
					.build();

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			scheduler.scheduleJob(job, trigger);
			scheduler.start();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {

		System.out.println(jobContext.getTrigger().getCalendarName() + "triggered.time is :" + new Date());

	}

}
