package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.CareProvider;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.model.PersonAdditionalInformation;
import com.crossasyst.personregistration.response.PersonResponse;
import com.crossasyst.personregistration.service.PersonService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "v1")
@Tag(name = "Person controller", description = "Add person details")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@RolesAllowed("admin")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person){
        PersonResponse personResponse= personService.CreatePerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/persons/{personId}/additional-info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<PersonAdditionalInformation> addAdditionalInfo(@RequestBody PersonAdditionalInformation personAdditionalInformation, @PathVariable Long personId){
       personAdditionalInformation= personService.addAdditionalInfo(personAdditionalInformation,personId);
       return new ResponseEntity<>(personAdditionalInformation, HttpStatus.OK);
    }

    @PostMapping(path = "/careprovider", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<CareProvider> addCareProvider(@RequestBody CareProvider careProvider){
        careProvider=personService.addCareProvider(careProvider);
        return new ResponseEntity<>(careProvider, HttpStatus.OK);
    }


}
