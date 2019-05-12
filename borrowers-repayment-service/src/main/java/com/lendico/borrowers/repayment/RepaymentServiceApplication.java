package com.lendico.borrowers.repayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lendico.borrowers.repayment")
public class RepaymentServiceApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(RepaymentServiceApplication.class, args);
    }
}
