package org.id.bankbatch;


import java.text.SimpleDateFormat;

import org.id.bankbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, BankTransaction>{
	
	private SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
	@Override
	public BankTransaction process(BankTransaction bankTransaction) throws Exception {
		bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
		return bankTransaction;
	}
	
	
}
