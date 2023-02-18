package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.CareProviderEntity;
import com.crossasyst.personregistration.model.CareProvider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareProviderMapper {

    CareProviderEntity modelToEntity(CareProvider careProvider);
}
