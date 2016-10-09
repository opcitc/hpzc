package com.hpzc.model.tms;

import java.util.Date;

public class HpzcCgdDetail {

	private String gCgsm;

	private String gCgsm1;

	private String isdelete;

	private String gXh;

	private String gId;

	private String gCode;

	private String gSpbh;

	private String gSpmc;

	private String gGysbh;

	private String gGysmc;

	private Double gSpdj;

	private String gCkbh;

	private String gCkmc;

	private String gCreate;

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark5;

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId == null ? null : gId.trim();
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode == null ? null : gCode.trim();
	}

	public String getgSpbh() {
		return gSpbh;
	}

	public void setgSpbh(String gSpbh) {
		this.gSpbh = gSpbh == null ? null : gSpbh.trim();
	}

	public String getgSpmc() {
		return gSpmc;
	}

	public void setgSpmc(String gSpmc) {
		this.gSpmc = gSpmc == null ? null : gSpmc.trim();
	}

	public String getgGysbh() {
		return gGysbh;
	}

	public void setgGysbh(String gGysbh) {
		this.gGysbh = gGysbh == null ? null : gGysbh.trim();
	}

	public String getgGysmc() {
		return gGysmc;
	}

	public void setgGysmc(String gGysmc) {
		this.gGysmc = gGysmc == null ? null : gGysmc.trim();
	}

	public Double getgSpdj() {
		return gSpdj;
	}

	public void setgSpdj(Double gSpdj) {
		this.gSpdj = gSpdj;
	}

	public String getgCkbh() {
		return gCkbh;
	}

	public void setgCkbh(String gCkbh) {
		this.gCkbh = gCkbh == null ? null : gCkbh.trim();
	}

	public String getgCkmc() {
		return gCkmc;
	}

	public void setgCkmc(String gCkmc) {
		this.gCkmc = gCkmc == null ? null : gCkmc.trim();
	}

	public String getgCreate() {
		return gCreate;
	}

	public void setgCreate(String gCreate) {
		this.gCreate = gCreate;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1 == null ? null : remark1.trim();
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2 == null ? null : remark2.trim();
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3 == null ? null : remark3.trim();
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4 == null ? null : remark4.trim();
	}

	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5 == null ? null : remark5.trim();
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getgCgsm() {
		return gCgsm;
	}

	public void setgCgsm(String gCgsm) {
		this.gCgsm = gCgsm;
	}

	public String getgCgsm1() {
		return gCgsm1;
	}

	public void setgCgsm1(String gCgsm1) {
		this.gCgsm1 = gCgsm1;
	}

	public String getgXh() {
		return gXh;
	}

	public void setgXh(String gXh) {
		this.gXh = gXh;
	}

	@Override
	public String toString() {
		return "HpzcCgdDetail [gCgsm=" + gCgsm + ", gCgsm1=" + gCgsm1 + ", isdelete=" + isdelete + ", gXh=" + gXh
				+ ", gId=" + gId + ", gCode=" + gCode + ", gSpbh=" + gSpbh + ", gSpmc=" + gSpmc + ", gGysbh=" + gGysbh
				+ ", gGysmc=" + gGysmc + ", gSpdj=" + gSpdj + ", gCkbh=" + gCkbh + ", gCkmc=" + gCkmc + ", gCreate="
				+ gCreate + ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4="
				+ remark4 + ", remark5=" + remark5 + "]";
	}

}