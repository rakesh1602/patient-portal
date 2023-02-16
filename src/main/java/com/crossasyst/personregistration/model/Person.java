package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String person_image;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email_id;

    private String gender;

    private Date birthDate;

    private String phoneNo;

    private String preferredName;

    private String birthSex;

    private String maritalStatus;

    private Boolean expired;

    private Date expiredDate;

    private List<Address> addressList;

    private PersonAdditionalInformation personAdditionalInformation;

    private List<PersonContact> personContacts;
}
