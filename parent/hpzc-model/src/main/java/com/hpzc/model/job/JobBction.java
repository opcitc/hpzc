package com.hpzc.model.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobBction implements Job {

	@Override
	public void execute(JobExecutionContext jobText) throws JobExecutionException {

		System.out.println("任务测试2");

		HpzcJob detailInfo = (HpzcJob) jobText.getMergedJobDataMap().get("scheduleJob");
		System.out.println("任务"+new Date());
		System.out.println(detailInfo);

	}

}
