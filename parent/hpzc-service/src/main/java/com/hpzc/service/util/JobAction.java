package com.hpzc.service.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.hpzc.model.job.HpzcJob;

public class JobAction implements Job {

	@Override
	public void execute(JobExecutionContext jobText) throws JobExecutionException {

		System.out.println("任务测试");

		HpzcJob detailInfo = (HpzcJob) jobText.getMergedJobDataMap().get("scheduleJob");

		System.out.println(detailInfo);

	}

}
