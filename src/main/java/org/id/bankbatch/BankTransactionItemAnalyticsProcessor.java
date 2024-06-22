package org.id.bankbatch;

import org.id.bankbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction>{
	
	private double totalDebit;
	private double totalCredit;
	@Override
	public BankTransaction process(BankTransaction bankTransaction) throws Exception {
		if (bankTransaction.getTransactionType().equals("D")) {
			totalDebit+=bankTransaction.getAmount();
		}else if (bankTransaction.getTransactionType().equals("C")) {
			totalCredit+=bankTransaction.getAmount();
		}
		return bankTransaction;
	}
}
