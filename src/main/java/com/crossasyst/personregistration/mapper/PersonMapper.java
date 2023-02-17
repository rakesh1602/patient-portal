package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "personAdditionalInformation", target = "personAdditionalInformationEntity")
    @Mapping(source = "addressList", target = "addressEntity")
    @Mapping(source = "personContacts", target = "personContactEntity")
    PersonEntity modelToEntity(Person person);
}
