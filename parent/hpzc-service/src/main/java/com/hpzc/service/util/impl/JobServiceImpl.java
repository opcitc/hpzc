package com.hpzc.service.util.impl;

import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceClient;

import org.quartz.Scheduler;
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
		// HpzcJob hpzcJob = scheduleJobVo.getTargetObject(ScheduleJob.class);
		JobManager.createScheduleJob(scheduler, hpzcJob);
		hpzcJobDao.insert(hpzcJob);

	}

	@Override
	public void update(HpzcJob hpzcJob) {
		JobManager.updateScheduleJob(scheduler, hpzcJob);
		hpzcJobDao.update(hpzcJob);
	}

	@Override
	public void delete(int jobId) {
		HpzcJob job = hpzcJobDao.selectByKey(jobId);
		// 删除运行的任务
		JobManager.deleteScheduleJob(scheduler, job.getJobName(), job.getJobGroup());
		// 删除数据
		hpzcJobDao.deleteByKey(jobId);

	}

	@Override
	public List<HpzcJob> selectByMap(Map<String, Object> map) {
		HpzcJob job = hpzcJobDao.selectByKey(12);
		return null;
	}

}
