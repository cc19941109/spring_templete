package com.chen.quartz.muljobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("jobA running at "+new Date());
	}
	

}
