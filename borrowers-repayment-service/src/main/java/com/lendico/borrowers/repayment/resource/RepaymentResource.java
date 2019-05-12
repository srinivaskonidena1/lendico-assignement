package com.lendico.borrowers.repayment.resource;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lendico.borrowers.repayment.model.PlanRequest;
import com.lendico.borrowers.repayment.service.PlanGeneratorService;

@Path("/repayment")
public class RepaymentResource {
	
	private final PlanGeneratorService planGeneratorService;
	
	@Inject
	public RepaymentResource(PlanGeneratorService planGeneratorService) {
		this.planGeneratorService = planGeneratorService;
	}
	
	@POST
	@Path("/plan/generate")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void getRepaymentPlan(@Context HttpServletRequest headers,
			@Suspended final AsyncResponse asyncResponse,
			PlanRequest planRequest) {
				
		CompletableFuture.supplyAsync(() -> planGeneratorService.generatePlan(planRequest))
		.thenApply(response -> Response.status(Response.Status.OK).entity(response).build())
		.exceptionally(t -> Response.status(Response.Status.EXPECTATION_FAILED).entity(t.getCause().getMessage()).build())
		.thenAccept(asyncResponse::resume);
		
	}	

}
