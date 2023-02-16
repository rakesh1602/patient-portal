package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.response.PersonResponse;
import com.crossasyst.personregistration.service.PersonServcie;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(name = "v1")
@Tag(name = "Person controller", description = "Add person details")
public class PersonController {

    private final PersonServcie personServcie;

    @Autowired
    public PersonController(PersonServcie personServcie) {
        this.personServcie = personServcie;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@RolesAllowed("admin")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person){
        PersonResponse personResponse=personServcie.CreatePerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }
}
