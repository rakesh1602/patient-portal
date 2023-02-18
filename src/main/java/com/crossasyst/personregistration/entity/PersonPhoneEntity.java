package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_contact")
public class PersonPhoneEntity {

    @Id
    @SequenceGenerator(name = "person_phone_seq_id", sequenceName = "person_phone_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_phone_seq_id")
    @Column(name = "person_contact_id")
    private Long personContactId;

    @Column(name = "phone_no")
    private Integer phoneNo;

    @Column(name = "phone_no_type")
    private String phoneNoType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;
}
