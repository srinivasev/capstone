package com.capstone.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Setter
@Getter
@Table(name="customeraddress")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerAddressId;

    @Column
    private Integer doorName;

    @Column
    private String streetName;

    @Column
    private String layout;

    @Column
    private String city;

    @Column
    private Integer pincode;
}
