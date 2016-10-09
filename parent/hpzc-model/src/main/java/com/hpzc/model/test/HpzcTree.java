package com.hpzc.model.test;

public class HpzcTree {

	private String id;

	private String text;

	private String state;

	private String iconCls;

	private String url;

	private String nid;

	private String status;

	private String isdelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "HpzcTree [id=" + id + ", text=" + text + ", state=" + state + ", iconCls=" + iconCls + ", url=" + url
				+ ", nid=" + nid + ", status=" + status + ", isdelete=" + isdelete + "]";
	}

}