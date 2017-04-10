package com.hpzc.service.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import com.hpzc.model.job.HpzcJob;

public class JobManager {

	/**
	 * 
	 * @Description : 获取触发器
	 * @author : zhengguohui
	 * @param job
	 * @return
	 * @time : 2017年4月7日 上午11:08:14
	 */
	public static TriggerKey getTriggerKey(String jobName, String jobGroup) {

		return TriggerKey.triggerKey(jobName, jobGroup);
	}

	/**
	 * 
	 * @Description : 获取表达式触发器
	 * @author : zhengguohui
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 * @return
	 * @time : 2017年4月7日 上午11:10:51
	 */

	public static CronTrigger getCronTrigger(Scheduler scheduler, String jobName, String jobGroup) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			return (CronTrigger) scheduler.getTrigger(triggerKey);
		} catch (SchedulerException e) {
			// throw new ScheduleException("获取定时任务CronTrigger出现异常");
		}
		return null;
	}

	/**
	 * 
	 * @Description : 创建任务
	 * @author : zhengguohui
	 * @param scheduler
	 * @param scheduleJob
	 * @time : 2017年4月7日 上午11:13:56
	 */
	public static void createScheduleJob(Scheduler scheduler, HpzcJob job) {
		createScheduleJob(scheduler, job.getJobName(), job.getJobGroup(), job.getJobTime(), job.getJobStatus(), job);
	}

	public static void createScheduleJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression,
			String status, Object param) {
		// 同步或异步
		// Class<? extends Job> jobClass = isSync ? JobSyncFactory.class :
		// JobFactory.class;
		Class<? extends Job> jobClass = JobAction.class;
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();

		// 放入参数，运行时的方法可以获取
		jobDetail.getJobDataMap().put("scheduleJob", param);

		// 表达式调度构建器
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder)
				.build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// LOG.error("创建定时任务失败", e);
			// throw new ScheduleException("创建定时任务失败");
		}
	}

	/**
	 * 运行一次任务
	 * 
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		try {
			scheduler.triggerJob(jobKey);
		} catch (SchedulerException e) {
			// LOG.error("运行一次定时任务失败", e);
			// throw new ScheduleException("运行一次定时任务失败");
		}
	}

	/**
	 * 暂停任务
	 * 
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		try {
			scheduler.pauseJob(jobKey);
		} catch (SchedulerException e) {
			// LOG.error("暂停定时任务失败", e);
			// throw new ScheduleException("暂停定时任务失败");
		}
	}

	/**
	 * 恢复任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		try {
			scheduler.resumeJob(jobKey);
		} catch (SchedulerException e) {
			// LOG.error("暂停定时任务失败", e);
			// throw new ScheduleException("暂停定时任务失败");
		}
	}

	/**
	 * 获取jobKey
	 *
	 * @param jobName
	 *            the job name
	 * @param jobGroup
	 *            the job group
	 * @return the job key
	 */
	public static JobKey getJobKey(String jobName, String jobGroup) {

		return JobKey.jobKey(jobName, jobGroup);
	}

	/**
	 * 更新定时任务
	 *
	 * @param scheduler
	 *            the scheduler
	 * @param scheduleJob
	 *            the schedule job
	 */
	public static void updateScheduleJob(Scheduler scheduler, HpzcJob job) {
		updateScheduleJob(scheduler, job.getJobName(), job.getJobGroup(), job.getJobTime(), job.getJobStatus(), job);
	}

	/**
	 * @Description : 更新定时任务
	 * @author : zhengguohui
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 * @param cronExpression
	 * @param status
	 * @param param
	 * @time : 2017年4月7日 上午11:32:04
	 */
	public static void updateScheduleJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression,
			String status, Object param) {
		try {
			TriggerKey triggerKey = JobManager.getTriggerKey(jobName, jobGroup);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			// LOG.error("更新定时任务失败", e);
			// throw new ScheduleException("更新定时任务失败");
		}
	}

	/**
	 * 删除定时任务
	 *
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 */
	public static void deleteScheduleJob(Scheduler scheduler, String jobName, String jobGroup) {
		try {
			scheduler.deleteJob(getJobKey(jobName, jobGroup));
		} catch (SchedulerException e) {
			// LOG.error("删除定时任务失败", e);
			// throw new ScheduleException("删除定时任务失败");
		}
	}

}
