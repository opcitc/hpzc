package com.hpzc.model.tms;

import java.util.Date;

public class HpzcStock {

	private String isdelete;

	private String sId;

	private String sCode;

	private String sMonth;

	private String sPdrq;

	private String sPdbh;

	private String sWpmc;

	private Integer sPdsl;

	private Double sPdje;

	private Integer sKcsl;

	private Double sKcje;

	private Integer sPysl;

	private Integer sPksl;

	private Double sPyje;

	private Double sPkje;

	private Date sModifier;

	private Date sCreate;

	private String remark1;

	private String remark3;

	private String remark2;

	private String remark4;

	private String remark5;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId == null ? null : sId.trim();
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode == null ? null : sCode.trim();
	}

	public String getsMonth() {
		return sMonth;
	}

	public void setsMonth(String sMonth) {
		this.sMonth = sMonth == null ? null : sMonth.trim();
	}

	public String getsPdrq() {
		return sPdrq;
	}

	public void setsPdrq(String sPdrq) {
		this.sPdrq = sPdrq == null ? null : sPdrq.trim();
	}

	public String getsPdbh() {
		return sPdbh;
	}

	public void setsPdbh(String sPdbh) {
		this.sPdbh = sPdbh == null ? null : sPdbh.trim();
	}

	public String getsWpmc() {
		return sWpmc;
	}

	public void setsWpmc(String sWpmc) {
		this.sWpmc = sWpmc == null ? null : sWpmc.trim();
	}

	public Integer getsPdsl() {
		return sPdsl;
	}

	public void setsPdsl(Integer sPdsl) {
		this.sPdsl = sPdsl;
	}

	public Double getsPdje() {
		return sPdje;
	}

	public void setsPdje(Double sPdje) {
		this.sPdje = sPdje;
	}

	public Integer getsKcsl() {
		return sKcsl;
	}

	public void setsKcsl(Integer sKcsl) {
		this.sKcsl = sKcsl;
	}

	public Double getsKcje() {
		return sKcje;
	}

	public void setsKcje(Double sKcje) {
		this.sKcje = sKcje;
	}

	public Integer getsPysl() {
		return sPysl;
	}

	public void setsPysl(Integer sPysl) {
		this.sPysl = sPysl;
	}

	public Integer getsPksl() {
		return sPksl;
	}

	public void setsPksl(Integer sPksl) {
		this.sPksl = sPksl;
	}

	public Double getsPyje() {
		return sPyje;
	}

	public void setsPyje(Double sPyje) {
		this.sPyje = sPyje;
	}

	public Double getsPkje() {
		return sPkje;
	}

	public void setsPkje(Double sPkje) {
		this.sPkje = sPkje;
	}

	public Date getsModifier() {
		return sModifier;
	}

	public void setsModifier(Date sModifier) {
		this.sModifier = sModifier;
	}

	public Date getsCreate() {
		return sCreate;
	}

	public void setsCreate(Date sCreate) {
		this.sCreate = sCreate;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1 == null ? null : remark1.trim();
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3 == null ? null : remark3.trim();
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2 == null ? null : remark2.trim();
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

	@Override
	public String toString() {
		return "HpzcStock [isdelete=" + isdelete + ", sId=" + sId + ", sCode=" + sCode + ", sMonth=" + sMonth
				+ ", sPdrq=" + sPdrq + ", sPdbh=" + sPdbh + ", sWpmc=" + sWpmc + ", sPdsl=" + sPdsl + ", sPdje=" + sPdje
				+ ", sKcsl=" + sKcsl + ", sKcje=" + sKcje + ", sPysl=" + sPysl + ", sPksl=" + sPksl + ", sPyje=" + sPyje
				+ ", sPkje=" + sPkje + ", sModifier=" + sModifier + ", sCreate=" + sCreate + ", remark1=" + remark1
				+ ", remark3=" + remark3 + ", remark2=" + remark2 + ", remark4=" + remark4 + ", remark5=" + remark5
				+ "]";
	}

}