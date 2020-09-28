package org.com.service;

import java.util.List;

import org.com.dto.TransferForm;
import org.com.exception.AccountNotFoundException;
import org.com.exception.WalletTXNNotFouException;
import org.com.exception.WalletTxnException;
import org.com.model.WalletTransaction;
import org.springframework.http.ResponseEntity;

public interface TransferFundService {

	public boolean transferFund(TransferForm transferForm) throws AccountNotFoundException, WalletTxnException;
	public ResponseEntity<?> searchTransaction(int transactionId) throws WalletTXNNotFouException;
	public List<WalletTransaction> getAllTransactions();
}
