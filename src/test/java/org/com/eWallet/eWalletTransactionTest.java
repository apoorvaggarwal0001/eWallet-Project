package org.com.eWallet;

import java.time.LocalDate;

import org.com.dto.TransferForm;
import org.com.model.WalletAccount;
import org.com.model.WalletTransaction;
import org.com.service.TransferFundService;
import org.com.service.TransferFundServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class eWalletTransactionTest {
	
	@Autowired
	TransferFundService transferFundService;
	
	@Test
	public void transferFundTest() {
		TransferForm transferForm=new TransferForm();
		transferForm.setFromaccountID(12345);
		transferForm.setToAccountID(67892);
		transferForm.setAmt(2000);
	}
}
