package com.access.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1716161538686048577L;
	private String name;
	private String surname;
	private String address;
	private int ccn;
	private Date ccexp;
	private String psw;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	public User() {
	}
	
	public User(String name, String surname, String address, int ccn, Date ccexp, String psw) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.ccn = ccn;
		this.ccexp = ccexp;
		this.psw = psw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCcn() {
		return ccn;
	}

	public void setCcn(int ccn) {
		this.ccn = ccn;
	}

	public Date getCcexp() {
		return ccexp;
	}

	public void setCcexp(Date ccexp) {
		this.ccexp = ccexp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
