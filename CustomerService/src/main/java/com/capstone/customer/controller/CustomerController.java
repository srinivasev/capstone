package com.capstone.customer.controller;

import com.capstone.customer.dto.CustomerDTO;
import com.capstone.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/searchCustomer/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") int customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @PostMapping("/addCustomer/")
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerPersisted = customerService.saveCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerPersisted);
    }

    @PutMapping("/updateCustomer/")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerUpdated = customerService.updateCustomer(customerDTO);
        return ResponseEntity.ok(customerUpdated);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }
}
