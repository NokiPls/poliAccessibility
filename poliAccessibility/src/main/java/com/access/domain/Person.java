package com.access.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = -9015553498567114557L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oid;
	@NotNull
	@Size(min=2)
	@Column(unique=true)
	private String name;
	@NotNull
	@Size(min=2)
	private String surname;
	private String address;
	private int ccn;
	private String ccexp;
	private String userName;
	private String passw;


	public Person() {
	}
	
	public Person(String name, String surname, String address, int ccn, String ccexp, String passw) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.ccn = ccn;
		this.ccexp = ccexp;
		this.passw = passw;
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

	public String getCcexp() {
		return ccexp;
	}

	public void setCcexp(String ccexp) {
		this.ccexp = ccexp;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}

}
