package com.zdotavv.enterprise_homework4.controller;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Person;
import com.zdotavv.enterprise_homework4.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

    @RestController
    @RequestMapping(path="/person")

    public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@RequestParam Long idPerson) throws NotFoundException {
        return personService.getPersonById(idPerson);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestParam Long idPerson, @RequestBody Person person) throws NotFoundException {
        return personService.updatePerson(idPerson, person);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@RequestParam Long idPerson) throws NotFoundException {
        personService.deletePerson(idPerson);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Person> getAll() {
        return personService.getAllPersons();
    }
}
