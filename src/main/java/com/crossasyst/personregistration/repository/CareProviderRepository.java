package com.crossasyst.personregistration.repository;

import com.crossasyst.personregistration.entity.CareProviderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareProviderRepository extends CrudRepository<CareProviderEntity, Long> {
}
