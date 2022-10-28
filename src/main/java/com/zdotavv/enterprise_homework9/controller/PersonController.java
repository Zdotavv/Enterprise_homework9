package com.zdotavv.enterprise_homework9.controller;

import com.zdotavv.enterprise_homework9.converters.PersonConverter;
import com.zdotavv.enterprise_homework9.dto.PersonDto;
import com.zdotavv.enterprise_homework9.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework9.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import java.util.stream.Collectors;

import static com.zdotavv.enterprise_homework9.converters.PersonConverter.convertPersonDtoToPerson;
import static com.zdotavv.enterprise_homework9.converters.PersonConverter.convertPersonToPersonDto;


@Controller
@RequestMapping(path="/person")
@Slf4j
    public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String personIndex(Model model) {
        String message = "Person control page";
        model.addAttribute("message", message);
        return "/person/personIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/createPerson";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") PersonDto personDto) {
        personService.createPerson(personDto.getFirstName(), personDto.getLastName(), personDto.getEmail(), personDto.getUsername(), personDto.getPassword());
        log.info("New person is created with username [{}] and email [{}]", personDto.getUsername(), personDto.getEmail());
        return "/person/createPersonSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPersonByIdView(Model model) {
        model.addAttribute("personById", new PersonDto());
        return "/person/getPerson";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Transactional
    public String getPersonById(@ModelAttribute("personById") PersonDto personDto, Model model) throws NotFoundException {
        PersonDto personById = convertPersonToPersonDto(personService.getPersonById(personDto.getIdPerson()));
        model.addAttribute("personById", personById);
        log.info("Person with ID [{}] is gotten", personDto.getIdPerson());
        return "/person/getPersonSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/updatePerson";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personService.updatePerson(convertPersonDtoToPerson(personDto));
        log.info("Person with ID [{}] is updated", personDto.getIdPerson());
        return "/person/updatePersonSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePersonByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/deletePerson";
    }


    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deletePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personService.deletePerson(personDto.getIdPerson());
        log.info("Person with ID [{}] is deleted", personDto.getIdPerson());
        return "/person/deletePersonSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllPersons(Model model) {
        model.addAttribute("all", personService.getAllPersons().stream().map(PersonConverter::convertPersonToPersonDto).collect(Collectors.toList()));
        return "/person/allPersons";
    }
}



