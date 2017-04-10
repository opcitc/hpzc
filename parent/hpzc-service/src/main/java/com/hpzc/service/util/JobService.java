package com.hpzc.service.util;

import java.util.List;
import java.util.Map;

import com.hpzc.model.job.HpzcJob;

public interface JobService {

	// 任务添加
	public void addJob(HpzcJob hpzcJob);

	// 任务更新
	public void update(HpzcJob hpzcJob);

	// 任务删除
	public void delete(int jobId);

	// 任务查询
	public List<HpzcJob> selectByMap(Map<String, Object> map);

}
