package com.hpzc.service.util.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.ws.WebServiceClient;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpzc.dao.job.HpzcJobMapper;
import com.hpzc.model.job.HpzcJob;
import com.hpzc.service.util.JobManager;
import com.hpzc.service.util.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private HpzcJobMapper hpzcJobDao;
	/** 调度工厂Bean */
	@Autowired
	private Scheduler scheduler;

	@Override
	public void addJob(HpzcJob hpzcJob) {
		
		JobManager.createScheduleJob(scheduler, hpzcJob);
//		hpzcJobDao.insert(hpzcJob);

	}

	@Override
	public void update(HpzcJob hpzcJob) {
		JobManager.updateScheduleJob(scheduler, hpzcJob);
//		hpzcJobDao.update(hpzcJob);
	}

	@Override
	public void delete(int jobId) {
//		HpzcJob job = hpzcJobDao.selectByKey(jobId);
		// 删除运行的任务
		JobManager.deleteScheduleJob(scheduler, "jobName1","dataWork2");
		// 删除数据
//		hpzcJobDao.deleteByKey(jobId);

	}

	@Override
	public List<HpzcJob> selectByMap(Map<String, Object> map) {
		HpzcJob job = hpzcJobDao.selectByKey(12);
		return null;
	}

	@Override
	public void stopJob(String name, String group) {
		JobKey key = JobKey.jobKey(name, group);
		try {
			scheduler.pauseJob(key);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void restartJob(String name, String group) {
		JobKey key = JobKey.jobKey(name, group);
		try {
			scheduler.resumeJob(key);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

}
