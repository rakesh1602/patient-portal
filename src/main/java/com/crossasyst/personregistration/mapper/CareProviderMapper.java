package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.CareProviderEntity;
import com.crossasyst.personregistration.model.CareProvider;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CareProviderMapper {

    @Mapping(source = "primaryCareProviderInformation", target = "primaryCareProviderInformationEntity")
    @Mapping(source = "primaryCareProviderName", target = "primaryCareProviderName")
    CareProviderEntity modelToEntity(CareProvider careProvider);
}
