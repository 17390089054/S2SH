package com.netbank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer accountid;
	private Status status;
	private String username;
	private String password;
	private Double balance;
	private Set<Personinfo> personinfos = new HashSet<Personinfo>(0);
	private Set<TransactionLog> transactionLogs = new HashSet<TransactionLog>(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(Status status, String username, String password, Double balance, Set<Personinfo> personinfos,
			Set<TransactionLog> transactionLogs) {
		this.status = status;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.personinfos = personinfos;
		this.transactionLogs = transactionLogs;
	}

	// Property accessors

	public Integer getAccountid() {
		return this.accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Set<Personinfo> getPersoninfos() {
		return this.personinfos;
	}

	public void setPersoninfos(Set<Personinfo> personinfos) {
		this.personinfos = personinfos;
	}

	public Set<TransactionLog> getTransactionLogs() {
		return this.transactionLogs;
	}

	public void setTransactionLogs(Set<TransactionLog> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

}