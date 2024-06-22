package org.id.bankbatch.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class BankTransaction {
	
	@Id
	private Long id;
	private long accountID;
	private Date transactionDate;
	@Transient
	private String strTransactionDate;
	private String transactionType;
	private double amount;
}
