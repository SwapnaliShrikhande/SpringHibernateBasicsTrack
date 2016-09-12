package com.hibernate.javaBased;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@javax.persistence.Entity
@Table(name = "NO")
public class No {
	@Id
	@GenericGenerator(name="swapnali", strategy="increment")
	@GeneratedValue(generator="swapnali")
	@Column(name = "NOID")
	private int noid;
	@Column(name="NUM")
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