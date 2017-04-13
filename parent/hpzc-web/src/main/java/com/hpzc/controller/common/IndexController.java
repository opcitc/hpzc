package com.hpzc.controller.common;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpzc.model.job.HpzcJob;
import com.hpzc.model.job.JobAction;
import com.hpzc.service.util.JobService;

@Controller
public class IndexController {

	@Autowired
	private JobService jobService;

	@RequestMapping("quartz")
	public String index() throws SchedulerException {
		HpzcJob job = new HpzcJob();
		job.setJobName("jobName");
		job.setJobStatus("1");
		job.setJobGroup("dataWork");
		job.setJobTime("0/5 * * * * ?");
		job.setJobMeme("测试");
		job.setClassName("com.hpzc.model.job.JobBction");
		jobService.addJob(job);
		System.out.println("quartz");
		return "tms/tms";
	}

	@RequestMapping("quartz1")
	public String index1() throws SchedulerException {
		HpzcJob job = new HpzcJob();
		job.setJobName("jobName1");
		job.setJobStatus("1");
		job.setJobGroup("dataWork2");
		job.setJobTime("0/8 * * * * ?");
		job.setJobMeme("测试1");
		jobService.delete(0);
		System.out.println("quartz1");
		return "tms/tms";
	}

	@RequestMapping("quartz2")
	public String index2() throws SchedulerException {
		HpzcJob job = new HpzcJob();
		job.setJobName("jobName");
		job.setJobStatus("1");
		job.setJobGroup("dataWork");
		job.setJobTime("0/5 * * * * ?");
		job.setJobMeme("测试");
		job.setClassName("");
		jobService.delete(12);
		System.out.println("quartz2");
		return "tms/tms";
	}
	
	

}
