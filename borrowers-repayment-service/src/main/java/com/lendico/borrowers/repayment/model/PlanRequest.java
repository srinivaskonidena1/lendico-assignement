package com.lendico.borrowers.repayment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanRequest {

	@JsonProperty
	private Double loanAmount;
	@JsonProperty
	private Double nominalRate;
	@JsonProperty
	private Integer duration;
	@JsonProperty
	private String startDate;
	
	@JsonCreator
	public PlanRequest(@JsonProperty("loanAmount") Double loanAmount, 
			@JsonProperty("nominalRate") Double nominalRate, 
			@JsonProperty("duration") Integer duration, 
			@JsonProperty("startDate") String startDate) {
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}


	public Double getLoanAmount() {
		return loanAmount;
	}


	public Double getNominalRate() {
		return nominalRate;
	}


	public Integer getDuration() {
		return duration;
	}


	public String getStartDate() {
		return startDate;
	}
}
