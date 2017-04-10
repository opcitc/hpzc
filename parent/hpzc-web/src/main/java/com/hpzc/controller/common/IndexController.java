package com.hpzc.controller.common;

import javax.annotation.Resource;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpzc.model.job.HpzcJob;
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
		jobService.addJob(job);
		System.out.println("quartz");
		return "tms/tms";
	}

}
