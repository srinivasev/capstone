package com.capstone.customer.service;

import com.capstone.customer.dto.CustomerAddressDTO;
import com.capstone.customer.dto.CustomerDTO;
import com.capstone.customer.entity.Customer;
import com.capstone.customer.entity.CustomerAddress;
import com.capstone.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {


    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public CustomerDTO getCustomer(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return convertCustomerToCustomerDTO(customer.get());
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        // develop modelmapper or util class for dto to entity object.
        System.out.println("Printing customer dto before persisting it " + customerDTO);
        Customer customerToPersist = convertCustomerDTOToCustomer(customerDTO);
        System.out.println("Printing customer persisting before persisting it " + customerToPersist);
        Customer customer = customerRepository.save(customerToPersist);
        return convertCustomerToCustomerDTO(customer);
    }

    private Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setCustomerName(customerDTO.getCustomerName());

        CustomerAddress billingAddress = new CustomerAddress();
        billingAddress.setCity(customerDTO.getCustomerBillingAddress().getCity());
        billingAddress.setDoorName(customerDTO.getCustomerBillingAddress().getDoorName());
        billingAddress.setPincode(customerDTO.getCustomerBillingAddress().getPincode());
        billingAddress.setLayout(customerDTO.getCustomerBillingAddress().getLayout());
        billingAddress.setStreetName(customerDTO.getCustomerBillingAddress().getStreetName());
        customer.setCustomerBillingAddress(billingAddress);

        CustomerAddress shippingAddress = new CustomerAddress();
        shippingAddress.setCity(customerDTO.getCustomerShippingAddress().getCity());
        shippingAddress.setDoorName(customerDTO.getCustomerShippingAddress().getDoorName());
        shippingAddress.setPincode(customerDTO.getCustomerShippingAddress().getPincode());
        shippingAddress.setLayout(customerDTO.getCustomerShippingAddress().getLayout());
        shippingAddress.setStreetName(customerDTO.getCustomerShippingAddress().getStreetName());
        customer.setCustomerShippingAddress(shippingAddress);

        return customer;
    }

    private CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO dtoObject = new CustomerDTO();

        dtoObject.setCustomerId(customer.getCustomerId());
        dtoObject.setCustomerName(customer.getCustomerName());

        CustomerAddressDTO billingAddress = new CustomerAddressDTO();
        billingAddress.setCity(customer.getCustomerBillingAddress().getCity());
        billingAddress.setDoorName(customer.getCustomerBillingAddress().getDoorName());
        billingAddress.setPincode(customer.getCustomerBillingAddress().getPincode());
        billingAddress.setLayout(customer.getCustomerBillingAddress().getLayout());
        billingAddress.setStreetName(customer.getCustomerBillingAddress().getStreetName());
        dtoObject.setCustomerBillingAddress(billingAddress);

        CustomerAddressDTO shippingAddress = new CustomerAddressDTO();
        shippingAddress.setCity(customer.getCustomerShippingAddress().getCity());
        shippingAddress.setDoorName(customer.getCustomerShippingAddress().getDoorName());
        shippingAddress.setPincode(customer.getCustomerShippingAddress().getPincode());
        shippingAddress.setLayout(customer.getCustomerShippingAddress().getLayout());
        shippingAddress.setStreetName(customer.getCustomerShippingAddress().getStreetName());
        dtoObject.setCustomerShippingAddress(shippingAddress);
        return dtoObject;
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException());
        customer.setCustomerName(customerDTO.getCustomerName());

        customer.getCustomerBillingAddress().setStreetName(customerDTO.getCustomerBillingAddress().getStreetName());
        customer.getCustomerBillingAddress().setLayout(customerDTO.getCustomerBillingAddress().getLayout());
        customer.getCustomerBillingAddress().setCity(customerDTO.getCustomerBillingAddress().getCity());
        customer.getCustomerBillingAddress().setPincode(customerDTO.getCustomerBillingAddress().getPincode());
        customer.getCustomerBillingAddress().setDoorName(customerDTO.getCustomerBillingAddress().getDoorName());

        customer.getCustomerShippingAddress().setStreetName(customerDTO.getCustomerShippingAddress().getStreetName());
        customer.getCustomerShippingAddress().setLayout(customerDTO.getCustomerShippingAddress().getLayout());
        customer.getCustomerShippingAddress().setCity(customerDTO.getCustomerShippingAddress().getCity());
        customer.getCustomerShippingAddress().setPincode(customerDTO.getCustomerShippingAddress().getPincode());
        customer.getCustomerShippingAddress().setDoorName(customerDTO.getCustomerShippingAddress().getDoorName());

        Customer updatedCustomer = customerRepository.save(customer);
        return convertCustomerToCustomerDTO(updatedCustomer);
    }
}
