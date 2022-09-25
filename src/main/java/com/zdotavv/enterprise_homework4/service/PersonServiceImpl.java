package com.zdotavv.enterprise_homework4.service;

import com.zdotavv.enterprise_homework4.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework4.model.Person;
import com.zdotavv.enterprise_homework4.repository.PersonRepository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long idPerson) throws NotFoundException {
        return personRepository
                .findById(idPerson)
                .orElseThrow(() -> new NotFoundException("Person with id: " + idPerson + " not found"));
    }

    @Override
    public Long deletePerson(Long idPerson) {
        if (personRepository.existsById(idPerson)) {
            personRepository.deleteById(idPerson);
            return idPerson;
        }
        try {
            throw new NotFoundException("Person with ID #" + idPerson + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Person updatePerson(Long idPerson, Person person) {
        return personRepository.findById(idPerson)
                .map(entity -> {
                    entity.setFirstName(person.getFirstName());
                    entity.setLastName(person.getLastName());
                    entity.setEmail(person.getEmail());
                    return personRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + idPerson));
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }
}
