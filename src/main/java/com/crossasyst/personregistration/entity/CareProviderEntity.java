package com.crossasyst.personregistration.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "care_provider")
public class CareProviderEntity {
    @Id
    @SequenceGenerator(name = "care_provider_seq_id", sequenceName = "care_provider_seq_id", initialValue = 40000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "care_provider_seq_id")
    @Column(name = "care_provider_id")
    private Long careProviderId;

    @Column(name = "primary_care_provider_name")
    private String primaryCareProviderName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "care_provider_id")
    private List<PrimaryCareProviderInformationEntity> primaryCareProviderInformationEntity;

    @OneToOne(mappedBy = "careProviderEntity")
    private PersonAdditionalInformationEntity personAdditionalInformationEntity;
}
