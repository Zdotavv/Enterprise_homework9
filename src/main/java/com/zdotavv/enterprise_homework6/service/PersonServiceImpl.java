package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.model.Person;
import com.zdotavv.enterprise_homework6.repository.PersonRepository;
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
        if (personRepository.findById(idPerson).isPresent()) {
            return personRepository.findById(idPerson).get();
        } else {
            throw new NotFoundException("Person with ID #" + idPerson + " is not found");
        }
    }

    @Override
    public void deletePerson(Long idPerson)throws NotFoundException {
        if (personRepository.existsById(idPerson)) {
            personRepository.deleteById(idPerson);
        }
    else {
        throw new NotFoundException("Person with ID #" + idPerson + " is not found");
    }

    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.findById(person.getIdPerson())
                .map(entity -> {
                    entity.setFirstName(person.getFirstName());
                    entity.setLastName(person.getLastName());
                    entity.setEmail(person.getEmail());
                    personRepository.save(entity);
                    return entity;
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + person.getIdPerson()));
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }
}
