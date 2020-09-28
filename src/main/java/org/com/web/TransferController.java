package org.com.web;

import java.util.List;

import org.com.dto.TransferForm;
import org.com.dto.WalletMessage;
import org.com.error.RecordNotFoundException;
import org.com.exception.AccountNotFoundException;
import org.com.exception.WalletTXNNotFouException;
import org.com.exception.WalletTxnException;
import org.com.model.WalletTransaction;
import org.com.service.TransferFundService;
import org.com.service.TransferFundServiceImpl;
import org.com.util.WalletConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*******************************************
 *Class: TransferController
 *Description: Dispatcherservlet maps the request to handler method transfer       
 
 *Created By   - Apoorv Aggarwal
 *                          	 
 ********************************************/
@RestController
@CrossOrigin("http://localhost:4200")
public class TransferController {

	@Autowired
	private TransferFundService service;
	
 /*******************************************
	 * Method:transferAccount
     *Description: Transfer amount from one account to another
	 * @param name   - Transform ref which contains fromAccId,toAccId,amount.
	 * @returns      -WalletMessage i.e.Tranfer Success
	 * @throws AccountNotFoundException, WalletTxnException- if Account not found 
     *Created By    - Apoorv Aggarwal
     *                         	 
	 ********************************************/

	@PostMapping("/transfer")
	public WalletMessage transferAccount( @RequestBody TransferForm transferForm) throws AccountNotFoundException, WalletTxnException 
	{
		System.out.println(transferForm);
		service.transferFund(transferForm);
		WalletMessage msg = new WalletMessage(WalletConstants.TRANSFER_SUCCESS);
		return msg;
		
	}
	
	@RequestMapping("/searchtransaction/{id}")
	public ResponseEntity<?> findtransaction(@PathVariable("id") int transactionId) throws WalletTXNNotFouException {
		return service.searchTransaction(transactionId);
	}
	
	@RequestMapping("/alltransactions")
	public List<WalletTransaction> getAllTransactions(){
		return service.getAllTransactions();
	}
	
}