package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.CareProviderEntity;
import com.crossasyst.personregistration.entity.PersonAdditionalInformationEntity;
import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.entity.PrimaryCareProviderInformationEntity;
import com.crossasyst.personregistration.mapper.CareProviderMapper;
import com.crossasyst.personregistration.mapper.PersonAdditionalInformationMapper;
import com.crossasyst.personregistration.mapper.PersonMapper;
import com.crossasyst.personregistration.model.CareProvider;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import com.crossasyst.personregistration.repository.CareProviderRepository;
import com.crossasyst.personregistration.repository.PersonAdditionalInformationRepository;
import com.crossasyst.personregistration.repository.PersonRepository;
import com.crossasyst.personregistration.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class PersonService {

    public final PersonMapper personMapper;

    public final PersonAdditionalInformationMapper personAdditionalInformationMapper;

    public final CareProviderMapper careProviderMapper;

    public final PersonRepository personRepository;

    public final PersonAdditionalInformationRepository personAdditionalInformationRepository;

    public final CareProviderRepository careProviderRepository;


    @Autowired
    public PersonService(PersonMapper personMapper, PersonAdditionalInformationMapper personAdditionalInformationMapper, CareProviderMapper careProviderMapper, PersonRepository personRepository, PersonAdditionalInformationRepository personAdditionalInformationRepository, CareProviderRepository careProviderRepository) {
        this.personMapper = personMapper;
        this.personAdditionalInformationMapper = personAdditionalInformationMapper;
        this.careProviderMapper = careProviderMapper;
        this.personRepository = personRepository;
        this.personAdditionalInformationRepository = personAdditionalInformationRepository;
        this.careProviderRepository = careProviderRepository;
    }

    public PersonResponse CreatePerson(Person person) {

        log.info("Adding person details");
        PersonEntity personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        log.info("Person details saved successfully.");

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getPersonId());
        log.info("Your person id is {}", personResponse.getId());
        return personResponse;
    }

    public PersonAdditionalInformation addAdditionalInfo(PersonAdditionalInformation personAdditionalInformation,Long personId) {
        log.info("Retrieving person details");
        PersonEntity personEntity = personRepository.findById(personId).get();

            PersonAdditionalInformationEntity personAdditionalInformationEntity = personAdditionalInformationMapper.modelToEntity(personAdditionalInformation);

            CareProvider careProvider=new CareProvider();
        careProvider.setPrimaryCareProviderName(personAdditionalInformation.getCareProvider().getPrimaryCareProviderName());
            careProvider.setPrimaryCareProviderInformation(personAdditionalInformation.getCareProvider().getPrimaryCareProviderInformation());

            CareProviderEntity careProviderEntity = careProviderMapper.modelToEntity(careProvider);
            careProviderRepository.save(careProviderEntity);
            log.info("Care provider details saved");

            personAdditionalInformationEntity.setPersonEntity(personEntity);
            personAdditionalInformationEntity.setCareProviderEntity(careProviderEntity);
            personAdditionalInformationRepository.save(personAdditionalInformationEntity);

        log.info("Person additional information saved.");
        return personAdditionalInformation;

    }


    public CareProvider addCareProvider(CareProvider careProvider, Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).get();

        if(personEntity !=null) {
            CareProviderEntity careProviderEntity1 = careProviderMapper.modelToEntity(careProvider);
            careProviderRepository.save(careProviderEntity1);
        }
        log.info("Care provider details saved");
        return careProvider;

    }
}
