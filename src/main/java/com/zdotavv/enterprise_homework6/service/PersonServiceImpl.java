package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.repository.PersonRepository;
import com.zdotavv.enterprise_homework6.dto.PersonDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.zdotavv.enterprise_homework6.converters.PersonConverter.convertPersonDtoToPerson;
import static com.zdotavv.enterprise_homework6.converters.PersonConverter.convertPersonToPersonDto;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;


    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        return convertPersonToPersonDto(personRepository.save(convertPersonDtoToPerson(personDto)));
    }

    @Override
    public PersonDto getPersonById(Long idPerson) throws NotFoundException {
        if (personRepository.findById(idPerson).isPresent()) {
            return convertPersonToPersonDto(personRepository.findById(idPerson).get());
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
//        try {
//            throw new NotFoundException("Person with ID #" + idPerson + " is not found");
//        } catch (NotFoundException e) {
//            throw new IllegalArgumentException(e);
//        }
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        return personRepository.findById(personDto.getIdPerson())
                .map(entity -> {
                    entity.setFirstName(personDto.getFirstName());
                    entity.setLastName(personDto.getLastName());
                    entity.setEmail(personDto.getEmail());
                    personRepository.save(entity);
                    return convertPersonToPersonDto(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + personDto.getIdPerson()));
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonDto> personDtoList = new ArrayList<>();
        personRepository.findAll().forEach(person -> personDtoList.add(convertPersonToPersonDto(person)));
        return personDtoList;
    }
}
