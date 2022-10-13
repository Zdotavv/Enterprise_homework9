package com.zdotavv.enterprise_homework6.service;

import com.zdotavv.enterprise_homework6.dto.PersonDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);

    PersonDto getPersonById(Long idPerson) throws NotFoundException;

    PersonDto updatePerson(PersonDto personDto) throws NotFoundException;

    void deletePerson(Long idPerson) throws NotFoundException;

    List<PersonDto> getAllPersons();
}
