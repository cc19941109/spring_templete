package com.cheng.quartzDemo.quickStart;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job{

	private final static Logger LOGGER = LoggerFactory.getLogger(HelloJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("job working ......");
	}
	

}
