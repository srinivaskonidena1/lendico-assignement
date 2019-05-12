package com.lendico.borrowers.repayment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder =Plan.PlanBuilder.class)
public class Plan {

	@JsonProperty
	private String borrowerPaymentAmount;
	@JsonProperty
	private String date;
	@JsonProperty
	private String initialOutstandingPrincipal;
	@JsonProperty
	private String interest;
	@JsonProperty
	private String principal;
	@JsonProperty
	private String remainingOutstandingPrincipal;
	
	private Plan() {
		
	}
	
	public static final class PlanBuilder {
		@JsonProperty
		private String borrowerPaymentAmount;
		@JsonProperty
		private String date;
		@JsonProperty
		private String initialOutstandingPrincipal;
		@JsonProperty
		private String interest;
		@JsonProperty
		private String principal;
		@JsonProperty
		private String remainingOutstandingPrincipal;
		
		public static PlanBuilder aPlanBuilder() {
			return new PlanBuilder();
		}
		
		public PlanBuilder withBorrowerPaymentAmount(String borrowerPaymentAmount) {
			this.borrowerPaymentAmount = borrowerPaymentAmount;
			return this;
		}
		
		
		public PlanBuilder withDate(String date) {
			this.date = date;
			return this;
		}
		
		public PlanBuilder withInitialOutstandingPrincipal(String initialOutstandingPrincipal) {
			this.initialOutstandingPrincipal = initialOutstandingPrincipal;
			return this;
		}
		
		public PlanBuilder withInterest(String interest) {
			this.interest = interest;
			return this;
		}
		
		public PlanBuilder withPrincipal(String principal) {
			this.principal = principal;
			return this;
		}
		
		public PlanBuilder withRemainingOutstandingPrincipal(String remainingOutstandingPrincipal) {
			this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
			return this;
		}
		
		public Plan build() {
			Plan plan = new Plan();
			
			plan.borrowerPaymentAmount = this.borrowerPaymentAmount;
			plan.date = this.date;
			plan.initialOutstandingPrincipal = this.initialOutstandingPrincipal;
			plan.interest = this.interest;
			plan.principal = this.principal;
			plan.remainingOutstandingPrincipal = this.remainingOutstandingPrincipal;
			
			return plan;
		}
	}
	
	

	public String getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	public String getDate() {
		return date;
	}

	public String getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	public String getInterest() {
		return interest;
	}

	public String getPrincipal() {
		return principal;
	}

	public String getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	@Override
	public String toString() {
		return "Plan [borrowerPaymentAmount=" + borrowerPaymentAmount + ", date=" + date
				+ ", initialOutstandingPrincipal=" + initialOutstandingPrincipal + ", interest=" + interest
				+ ", principal=" + principal + ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal + "]";
	}
	
	
	
}
