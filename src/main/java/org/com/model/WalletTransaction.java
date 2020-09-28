package org.com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="abes_wallet_transaction")
public class WalletTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="date_of_transaction")
	private LocalDate dateOfTransaction;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private WalletAccount account;
	

	@Column(name="tx_details")
	private String transactionDetails;

	@Column(name="tx_type")
	private String transactionType;
	
	public int getTransactionId() {
		return transactionId;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public WalletAccount getAccount() {
		return account;
	}


	public void setAccount(WalletAccount account) {
		this.account = account;
	}


	public String getTransactionDetails() {
		return transactionDetails;
	}


	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	
	
}
