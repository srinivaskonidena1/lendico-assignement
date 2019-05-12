package com.lendico.borrowers.repayment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.borrowers.repayment.model.Plan;
import com.lendico.borrowers.repayment.model.PlanRequest;

@Service
public interface PlanGeneratorService {
	
	public List<Plan> generatePlan(PlanRequest planRequest);

}
