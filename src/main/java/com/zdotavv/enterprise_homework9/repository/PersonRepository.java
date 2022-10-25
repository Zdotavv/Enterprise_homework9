package com.zdotavv.enterprise_homework9.repository;


import com.zdotavv.enterprise_homework9.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findPersonByUsername(String username);

}
