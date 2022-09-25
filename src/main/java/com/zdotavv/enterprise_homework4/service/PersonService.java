package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    Person getPersonById(Long id) throws NotFoundException;

    Person updatePerson(Long Id, Person person) throws NotFoundException;

    Long deletePerson(Long id) throws NotFoundException;

    List<Person> getAllPersons();
}
