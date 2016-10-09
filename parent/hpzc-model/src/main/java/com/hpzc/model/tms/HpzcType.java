package com.hpzc.model.tms;

import java.util.Date;

public class HpzcType {

	private String isdelete;

	private String phoneId;

	private String phoneCode;

	private String phoneName;

	private String phoneSubjection;

	private String phoneEnable;

	private Date phoneXgrq;

	private Date phoneCjrq;

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId == null ? null : phoneId.trim();
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode == null ? null : phoneCode.trim();
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName == null ? null : phoneName.trim();
	}

	public String getPhoneSubjection() {
		return phoneSubjection;
	}

	public void setPhoneSubjection(String phoneSubjection) {
		this.phoneSubjection = phoneSubjection == null ? null : phoneSubjection.trim();
	}

	public String getPhoneEnable() {
		return phoneEnable;
	}

	public void setPhoneEnable(String phoneEnable) {
		this.phoneEnable = phoneEnable == null ? null : phoneEnable.trim();
	}

	public Date getPhoneXgrq() {
		return phoneXgrq;
	}

	public void setPhoneXgrq(Date phoneXgrq) {
		this.phoneXgrq = phoneXgrq;
	}

	public Date getPhoneCjrq() {
		return phoneCjrq;
	}

	public void setPhoneCjrq(Date phoneCjrq) {
		this.phoneCjrq = phoneCjrq;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

}