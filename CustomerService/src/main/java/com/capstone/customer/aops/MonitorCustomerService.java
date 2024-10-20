package com.capstone.customer.aops;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDate;
import java.util.Date;

@Aspect
public class MonitorCustomerService {

    private LocalDate date;

    //@Pointcut("execution(* com.capstone.customer.service.CustomerService.getCustomer(int))")
    @Pointcut("execution(* com.capstone.customer.service.*.*(..))")
    public void printTimeTaken(){}

    @Before("printTimeTaken()")
    public void beforeMethod(){
        System.out.println("Printing time before "+ new Date());
    }

    @After("printTimeTaken()")
    public void afterMethod(){
        System.out.println("Printing time after "+ new Date());
    }
}
