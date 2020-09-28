package org.com.web;

import org.com.dto.ErrorMessage;
import org.com.exception.AccountNotFoundException;
import org.com.exception.LoginException;
import org.com.exception.WalletTxnException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletExceptionAdvice {
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleNotFoundException(AccountNotFoundException ex) {
		return new ErrorMessage(ex.getMessage());
		
	}
	
	@ExceptionHandler({WalletTxnException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBadREquestException(Exception ex) {
		return new ErrorMessage(ex.getMessage());
		
	}
}
