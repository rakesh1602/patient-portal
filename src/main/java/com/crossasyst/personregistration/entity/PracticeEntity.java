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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "practice")
public class PracticeEntity {

    @Id
    @SequenceGenerator(name = "practice_seq_id", sequenceName = "practice_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practice_seq_id")
    @Column(name = "practice_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private EnterpriseEntity enterpriseEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<PatientEntity> patientEntityList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<LocationEntity> locationEntity;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<PracticeContactEntity> practiceContactEntity;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<PracticeStaffEntity> practiceStaffEntities;

}
