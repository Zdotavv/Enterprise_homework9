package com.zdotavv.enterprise_homework7.service;

import com.zdotavv.enterprise_homework7.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework7.model.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PersonService extends UserDetailsService {
    Person createPerson(String firstName, String lastName, String email, String username, String password);

    Person getPersonById(Long idPerson) throws NotFoundException;

    Person updatePerson(Person person) throws NotFoundException;

    void deletePerson(Long idPerson) throws NotFoundException;

    List<Person> getAllPersons();
    Person getPersonByUsername(String username);
}
