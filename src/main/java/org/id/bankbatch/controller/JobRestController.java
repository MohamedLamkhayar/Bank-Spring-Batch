package org.id.bankbatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.id.bankbatch.BankTransactionItemAnalyticsProcessor;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestController {
	
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	@Autowired
	private BankTransactionItemAnalyticsProcessor analyticsProcessor;
	
	
	@GetMapping("/startJob")
	public BatchStatus load() throws Exception {
		
		Map<String, JobParameter> params = new HashMap<String, JobParameter>();
		params.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(params);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		while (jobExecution.isRunning()) {
		System.out.println(".......");
		}
		return jobExecution.getStatus();
		
	}
	
	@GetMapping("/analytics")
	public Map<String, Double> analytics() {
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("totalCredit", analyticsProcessor.getTotalCredit());
		map.put("totalDebit", analyticsProcessor.getTotalDebit());
		return map;
	}
}
