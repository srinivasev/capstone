package com.capstone.customer.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerAddressDTO {

    private Integer doorName;

    private String streetName;

    private String layout;

    private String city;

    private Integer pincode;
}
