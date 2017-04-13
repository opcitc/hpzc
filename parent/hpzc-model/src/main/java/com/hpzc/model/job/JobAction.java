package com.hpzc.model.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobAction implements Job {

	@Override
	public void execute(JobExecutionContext jobText) throws JobExecutionException {

		System.out.println("任务测试");

		HpzcJob detailInfo = (HpzcJob) jobText.getMergedJobDataMap().get("scheduleJob");
		System.out.println("test" + new Date());
		System.out.println(detailInfo);

	}

}
