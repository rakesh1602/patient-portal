package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.mapper.PersonMapper;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.repository.PersonRepository;
import com.crossasyst.personregistration.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonServcie {

    public final PersonMapper personMapper;

    public final PersonRepository personRepository;

    @Autowired
    public PersonServcie(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public PersonResponse CreatePerson(Person person) {

        log.info("Adding person details");
        PersonEntity personEntity=personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        log.info("Person details saved successfully.");

        PersonResponse personResponse=new PersonResponse();
        personResponse.setId(personEntity.getPersonId());
        log.info("Your person id is {}", personResponse.getId());
        return personResponse;
    }
}
