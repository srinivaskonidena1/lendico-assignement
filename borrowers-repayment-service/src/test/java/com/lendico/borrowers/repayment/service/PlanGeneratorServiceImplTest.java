package com.lendico.borrowers.repayment.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lendico.borrowers.repayment.model.Plan;
import com.lendico.borrowers.repayment.model.PlanRequest;

public class PlanGeneratorServiceImplTest {
	
	private PlanGeneratorService planGeneratorService;
	
	@Before
	public void load() {
		planGeneratorService = new PlanGeneratorServiceImpl();
	}
	
	@Test
	public void testGeneratePlan() {
		PlanRequest request = createPlanRequest();
		List<Plan> planList = planGeneratorService.generatePlan(request);
		Assert.assertEquals(request.getDuration().intValue(), planList.size());
		Assert.assertTrue(planList
				.stream()
				.allMatch(p -> "219.36".equals(p.getBorrowerPaymentAmount())));
	}
	
	private PlanRequest createPlanRequest() {
		PlanRequest request = new PlanRequest(5000d, 5.0d, 24, "2018-01-01T00:00:01Z");
		return request;
	}

}
