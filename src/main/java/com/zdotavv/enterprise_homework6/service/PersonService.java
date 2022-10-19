package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    Person getPersonById(Long idPerson) throws NotFoundException;

    Person updatePerson(Person personD) throws NotFoundException;

    void deletePerson(Long idPerson) throws NotFoundException;

    List<Person> getAllPersons();
}
