package com.hpzc.model.tms;

import java.util.Date;

public class HpzcCustomer {

	private String isdelete;

	private String cId;

	private String cCode;

	private String cName;

	private String cAddress;

	private String cLink;

	private String cTel;

	private String cMail;

	private String cQq;

	private String cWeixin;

	private String cMemo;

	private String cBank1;

	private String cAccount1;

	private String cBank2;

	private String cAccount2;

	private Date cCreate;

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark6;

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId == null ? null : cId.trim();
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode == null ? null : cCode.trim();
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName == null ? null : cName.trim();
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress == null ? null : cAddress.trim();
	}

	public String getcLink() {
		return cLink;
	}

	public void setcLink(String cLink) {
		this.cLink = cLink == null ? null : cLink.trim();
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel == null ? null : cTel.trim();
	}

	public String getcMail() {
		return cMail;
	}

	public void setcMail(String cMail) {
		this.cMail = cMail == null ? null : cMail.trim();
	}

	public String getcQq() {
		return cQq;
	}

	public void setcQq(String cQq) {
		this.cQq = cQq == null ? null : cQq.trim();
	}

	public String getcWeixin() {
		return cWeixin;
	}

	public void setcWeixin(String cWeixin) {
		this.cWeixin = cWeixin == null ? null : cWeixin.trim();
	}

	public String getcMemo() {
		return cMemo;
	}

	public void setcMemo(String cMemo) {
		this.cMemo = cMemo == null ? null : cMemo.trim();
	}

	public String getcBank1() {
		return cBank1;
	}

	public void setcBank1(String cBank1) {
		this.cBank1 = cBank1 == null ? null : cBank1.trim();
	}

	public String getcAccount1() {
		return cAccount1;
	}

	public void setcAccount1(String cAccount1) {
		this.cAccount1 = cAccount1 == null ? null : cAccount1.trim();
	}

	public String getcBank2() {
		return cBank2;
	}

	public void setcBank2(String cBank2) {
		this.cBank2 = cBank2 == null ? null : cBank2.trim();
	}

	public String getcAccount2() {
		return cAccount2;
	}

	public void setcAccount2(String cAccount2) {
		this.cAccount2 = cAccount2 == null ? null : cAccount2.trim();
	}

	public Date getcCreate() {
		return cCreate;
	}

	public void setcCreate(Date cCreate) {
		this.cCreate = cCreate;
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

	public String getRemark6() {
		return remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6 == null ? null : remark6.trim();
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

}