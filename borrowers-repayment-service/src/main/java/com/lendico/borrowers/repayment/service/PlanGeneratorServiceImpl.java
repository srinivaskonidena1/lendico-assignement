package com.lendico.borrowers.repayment.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.borrowers.repayment.exception.GenerationException;
import com.lendico.borrowers.repayment.model.Plan;
import com.lendico.borrowers.repayment.model.Plan.PlanBuilder;
import com.lendico.borrowers.repayment.model.PlanRequest;

@Service
public class PlanGeneratorServiceImpl implements PlanGeneratorService{
	
    public List<Plan> generatePlan(PlanRequest planRequest) {
    	
    	List<Plan> planList = new ArrayList<>();
    	try {
    		
    		DecimalFormat decimalFormat = new DecimalFormat("#.00");
    		Instant instant = Instant.parse(planRequest.getStartDate());
    		LocalDateTime loanStartDate = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        	Double ratePerPeriod = (planRequest.getNominalRate()/12)/100;
        	Double annuity = ( (ratePerPeriod * planRequest.getLoanAmount() ) / 
        			(1 - Math.pow( (1 + ratePerPeriod), -planRequest.getDuration())));
        	
        	Double intialOutstanding = planRequest.getLoanAmount();
        	
        	for(int paymentNumber=1; paymentNumber <= planRequest.getDuration(); paymentNumber++) {
        		
        		PlanBuilder planBuilder = Plan.PlanBuilder.aPlanBuilder();
        		planBuilder.withBorrowerPaymentAmount(decimalFormat.format(annuity));
        		planBuilder.withInitialOutstandingPrincipal(decimalFormat.format(intialOutstanding));
        		planBuilder.withDate(loanStartDate.plusMonths(paymentNumber-1).toString());
        		        		
        		Double interest = ((planRequest.getNominalRate() * 30 * intialOutstanding) / 360) / 100;
        		planBuilder.withInterest(decimalFormat.format(interest));
        		
        		Double principal = annuity - interest;
        		planBuilder.withPrincipal(decimalFormat.format(principal));
        		
        		Double remainingOutstanding = intialOutstanding - principal;
        		planBuilder.withRemainingOutstandingPrincipal(decimalFormat.format(remainingOutstanding));
        		
        		Plan plan = planBuilder.build();
        		planList.add(plan);
        		
        		intialOutstanding = remainingOutstanding;
        	}
    	}
    	catch (Exception e) {
			throw new GenerationException("Technical error occured while generation the repayment plan", e);
		}
    	
    			
		return planList;
	}

}
