package com.zdotavv.enterprise_homework9.repository;

import com.zdotavv.enterprise_homework9.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findRoleByName(String name);

}
