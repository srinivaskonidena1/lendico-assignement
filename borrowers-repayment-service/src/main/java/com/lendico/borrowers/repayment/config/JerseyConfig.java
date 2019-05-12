package com.lendico.borrowers.repayment.config;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.lendico.borrowers.repayment.resource.RepaymentResource;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(RepaymentResource.class);
	}
}
