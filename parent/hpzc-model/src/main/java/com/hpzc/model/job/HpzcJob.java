package com.hpzc.model.job;

import java.io.Serializable;

import org.quartz.Job;

public class HpzcJob implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer jobId;

	private String jobName;

	private String jobGroup;

	private String jobStatus;

	private String jobTime;

	private String jobMeme;

	private String className;

	private String jobBy1;

	private String jobBy2;

	private String jobBy3;

	private String jobBy4;

	private String jobBy5;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup == null ? null : jobGroup.trim();
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus == null ? null : jobStatus.trim();
	}

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime == null ? null : jobTime.trim();
	}

	public String getJobMeme() {
		return jobMeme;
	}

	public void setJobMeme(String jobMeme) {
		this.jobMeme = jobMeme == null ? null : jobMeme.trim();
	}

	public String getJobBy1() {
		return jobBy1;
	}

	public void setJobBy1(String jobBy1) {
		this.jobBy1 = jobBy1 == null ? null : jobBy1.trim();
	}

	public String getJobBy2() {
		return jobBy2;
	}

	public void setJobBy2(String jobBy2) {
		this.jobBy2 = jobBy2 == null ? null : jobBy2.trim();
	}

	public String getJobBy3() {
		return jobBy3;
	}

	public void setJobBy3(String jobBy3) {
		this.jobBy3 = jobBy3 == null ? null : jobBy3.trim();
	}

	public String getJobBy4() {
		return jobBy4;
	}

	public void setJobBy4(String jobBy4) {
		this.jobBy4 = jobBy4 == null ? null : jobBy4.trim();
	}

	public String getJobBy5() {
		return jobBy5;
	}

	public void setJobBy5(String jobBy5) {
		this.jobBy5 = jobBy5 == null ? null : jobBy5.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "HpzcJob [jobId=" + jobId + ", jobName=" + jobName + ", jobGroup=" + jobGroup + ", jobStatus="
				+ jobStatus + ", jobTime=" + jobTime + ", jobMeme=" + jobMeme + ", className=" + className + ", jobBy1="
				+ jobBy1 + ", jobBy2=" + jobBy2 + ", jobBy3=" + jobBy3 + ", jobBy4=" + jobBy4 + ", jobBy5=" + jobBy5
				+ "]";
	}

}