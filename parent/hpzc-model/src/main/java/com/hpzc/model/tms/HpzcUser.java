package com.hpzc.model.tms;

import java.io.Serializable;

public class HpzcUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String isdelete;

	private int uId;

	private String username;

	private String password;

	private String name;

	private String tel;

	private String uNo;

	private String khh;

	private String yhzh;

	private String qq;

	private String weixin;

	private String mail;

	private String jjlxr;

	private String jjlxrtel;

	private String address;

	private String other;

	private String orgCode;

	private String orgName;

	private String orgCodesj;

	private String orgNamesj;

	private String memo;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getuNo() {
		return uNo;
	}

	public void setuNo(String uNo) {
		this.uNo = uNo == null ? null : uNo.trim();
	}

	public String getKhh() {
		return khh;
	}

	public void setKhh(String khh) {
		this.khh = khh == null ? null : khh.trim();
	}

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh == null ? null : yhzh.trim();
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin == null ? null : weixin.trim();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}

	public String getJjlxr() {
		return jjlxr;
	}

	public void setJjlxr(String jjlxr) {
		this.jjlxr = jjlxr == null ? null : jjlxr.trim();
	}

	public String getJjlxrtel() {
		return jjlxrtel;
	}

	public void setJjlxrtel(String jjlxrtel) {
		this.jjlxrtel = jjlxrtel == null ? null : jjlxrtel.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	public String getOrgCodesj() {
		return orgCodesj;
	}

	public void setOrgCodesj(String orgCodesj) {
		this.orgCodesj = orgCodesj == null ? null : orgCodesj.trim();
	}

	public String getOrgNamesj() {
		return orgNamesj;
	}

	public void setOrgNamesj(String orgNamesj) {
		this.orgNamesj = orgNamesj == null ? null : orgNamesj.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "HpzcUser [isdelete=" + isdelete + ", uId=" + uId + ", username=" + username + ", password=" + password
				+ ", name=" + name + ", tel=" + tel + ", uNo=" + uNo + ", khh=" + khh + ", yhzh=" + yhzh + ", qq=" + qq
				+ ", weixin=" + weixin + ", mail=" + mail + ", jjlxr=" + jjlxr + ", jjlxrtel=" + jjlxrtel + ", address="
				+ address + ", other=" + other + ", orgCode=" + orgCode + ", orgName=" + orgName + ", orgCodesj="
				+ orgCodesj + ", orgNamesj=" + orgNamesj + ", memo=" + memo + "]";
	}

}