package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @SequenceGenerator(name = "person_seq_id", sequenceName = "person_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_id")
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "person_image")
    private String person_image;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "preferred_name")
    private String preferredName;

    @Column(name = "birth_sex")
    private String birthSex;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "expired")
    private Boolean expired;

    @Column(name = "expired_date")
    private Date expiredDate;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<AddressEntity> addressEntity;

    @OneToOne(mappedBy = "personEntity")
    private PersonAdditionalInformationEntity personAdditionalInformationEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_Id")
    private List<PersonPhoneEntity> personPhoneEntity;

}
