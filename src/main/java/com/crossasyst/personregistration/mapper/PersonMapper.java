package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity modelToEntity(Person person);
}
