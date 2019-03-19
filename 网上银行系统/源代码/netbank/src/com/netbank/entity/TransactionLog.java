package com.netbank.entity;

/**
 * TransactionLog entity. @author MyEclipse Persistence Tools
 */

public class TransactionLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private TransactionType transactionType;
	private Integer otherid;
	private Double trMoney;
	private String datetime;

	// Constructors

	/** default constructor */
	public TransactionLog() {
	}

	/** full constructor */
	public TransactionLog(Account account, TransactionType transactionType, Integer otherid, Double trMoney,
			String datetime) {
		this.account = account;
		this.transactionType = transactionType;
		this.otherid = otherid;
		this.trMoney = trMoney;
		this.datetime = datetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getOtherid() {
		return this.otherid;
	}

	public void setOtherid(Integer otherid) {
		this.otherid = otherid;
	}

	public Double getTrMoney() {
		return this.trMoney;
	}

	public void setTrMoney(Double trMoney) {
		this.trMoney = trMoney;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}