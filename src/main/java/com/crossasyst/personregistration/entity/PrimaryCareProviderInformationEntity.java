package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "primary_care_provider_information")
public class PrimaryCareProviderInformationEntity {
    @Id
    @SequenceGenerator(name = "primary_care_provider_information_seq_id", sequenceName = "primary_care_provider_information_seq_id", initialValue = 50000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_care_provider_information_seq_id")
    @Column(name = "primary_care_provider_information_id")
    private Long primaryCareProviderInformationId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_no")
    private String phoneNumber;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_Line_2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "care_provider_id")
    private CareProviderEntity careProviderEntity;

}
