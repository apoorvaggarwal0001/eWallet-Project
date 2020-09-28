package org.com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.com.dao.WalletAccountDao;
import org.com.dao.WalletTransactionDao;
import org.com.dto.TransferForm;
import org.com.error.RecordNotFoundException;
import org.com.exception.AccountNotFoundException;
import org.com.exception.WalletTXNNotFouException;
import org.com.exception.WalletTxnException;
import org.com.model.WalletAccount;
import org.com.model.WalletTransaction;
import org.com.util.WalletConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountser")
@Transactional
public class TransferFundServiceImpl implements TransferFundService {

	@Autowired
	private WalletAccountDao accDao;
	
	@Autowired
	private WalletTransactionDao transDao;


/*******************************************
	 * Method:transferfund
     *Description: Transfer amount from one account to another
	 * @param name   - Transform ref which contains fromAccId,toAccId,amount.
	 * @returns      -boolean 
	 * @throws AccountNotFoundException, WalletTxnException- if Account not found 
     *Created By    - Apoorv Aggarwal
     *                         	 
	 ********************************************/

	@Override
	public boolean transferFund(TransferForm transferForm) throws AccountNotFoundException, WalletTxnException {
		WalletAccount fromAccount = accDao.getWalletAccount(transferForm.getFromaccountID());
		if (fromAccount == null)
			throw new AccountNotFoundException(WalletConstants.INVALID_ACCOUNT);
		WalletAccount toAccount = accDao.getWalletAccount(transferForm.getToAccountID());
		if (toAccount == null)
			throw new AccountNotFoundException(WalletConstants.INVALID_ACCOUNT);
		if (fromAccount.getAccountBalance() < transferForm.getAmt())
			throw new WalletTxnException(WalletConstants.INSUFFICIENT_BALANCE);
		fromAccount.setAccountBalance(fromAccount.getAccountBalance() - transferForm.getAmt());
		toAccount.setAccountBalance(toAccount.getAccountBalance() + transferForm.getAmt());
		
		accDao.save(fromAccount);
		addTxn(fromAccount, transferForm.getAmt(), WalletConstants.DEBIT, WalletConstants.TRANSFERED_TO + toAccount.getAccountId());
				
		accDao.save(toAccount);
		addTxn(toAccount, transferForm.getAmt(), WalletConstants.CREDIT, WalletConstants.TRANSFERED_FROM + fromAccount.getAccountId());
		return true;
	}


/*******************************************
	 * Method:addtxn
     *Description: adds a transaction  when transfer is successful
	 * @param name   - account, amount, txType, description,phoneNo
	 * @returns      -boolean 
     *Created By    - Apoorv Aggarwal
     *                           	 
	 ********************************************/

	public boolean addTxn(WalletAccount account, double amount, String txType, String description) {
		WalletTransaction walletTxn = new WalletTransaction();
		walletTxn.setTransactionDetails(description);
		walletTxn.setDateOfTransaction(LocalDate.now());
		walletTxn.setTransactionType(txType);
		walletTxn.setAmount(amount);
		walletTxn.setAccount(account);
		transDao.save(walletTxn);
		return true;
	}
	
	public ResponseEntity<?> searchTransaction(int transactionId) throws WalletTXNNotFouException{
		Optional<WalletTransaction> findById=transDao.findById(transactionId);
			if(findById.isPresent()) {
				WalletTransaction transaction=findById.get();
				return new ResponseEntity<WalletTransaction>(transaction,HttpStatus.OK);
			}
			else
				throw new WalletTXNNotFouException(WalletConstants.NO_TXN_AVAILABLE);
	}
	
	public List<WalletTransaction> getAllTransactions(){
		return transDao.findAll();
	}
}