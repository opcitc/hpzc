package com.hpzc.model.common;

public class Order {

	private String field;
	private String dir;
	private boolean isDBField;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public boolean isDBField() {
		return isDBField;
	}

	public void setDBField(boolean isDBField) {
		this.isDBField = isDBField;
	}

	@Override
	public String toString() {
		return "Order [field=" + field + ", dir=" + dir + ", isDBField=" + isDBField + "]";
	}

}
