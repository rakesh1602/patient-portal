package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonContact {
    private String cityAbbreviation;
    private String cityName;
    private State state;

    private Person person;
}
