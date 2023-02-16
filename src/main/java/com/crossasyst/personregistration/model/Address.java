package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address1;
    private String address2;
    private String addressType;
    private String country;
    private String state;
    private String city;
    private Long zipCode;

    private Person person;
}
