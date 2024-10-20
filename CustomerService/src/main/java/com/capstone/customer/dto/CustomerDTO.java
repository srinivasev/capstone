package com.capstone.customer.dto;


import com.capstone.customer.entity.CustomerAddress;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {

    private Integer customerId;
    private String customerName;
    private CustomerAddressDTO customerBillingAddress;
    private CustomerAddressDTO customerShippingAddress;

}
