package com.capstone.customer.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@ToString
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column
    private String customerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="billing_address")
    private CustomerAddress customerBillingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shipping_address")
    private CustomerAddress customerShippingAddress;

}
