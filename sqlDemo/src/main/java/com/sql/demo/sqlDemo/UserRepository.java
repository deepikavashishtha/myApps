package com.sql.demo.sqlDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sql.demo.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}