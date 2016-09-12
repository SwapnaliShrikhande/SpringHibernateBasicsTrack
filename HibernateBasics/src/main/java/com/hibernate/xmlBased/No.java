package com.hibernate.xmlBased;

public class No {
	private static final long serialVersionUID = -75885815725314843L;
	
	private int noid;
	private String num;
	
	public No() {
	}
	
	public No(String number) {
		this.num = number;
	}
	
	public int getNoid() {
		return noid;
	}

	public void setNoid(int noid) {
		this.noid = noid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
}