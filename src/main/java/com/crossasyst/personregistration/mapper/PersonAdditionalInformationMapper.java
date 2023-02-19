package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PersonAdditionalInformationEntity;
import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonAdditionalInformationMapper {

    @Mapping(source = "careProvider", target = "careProviderEntity")
    PersonAdditionalInformationEntity modelToEntity(PersonAdditionalInformation personAdditionalInformation);
}
