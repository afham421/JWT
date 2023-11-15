package com.jwt.Repository;

import com.jwt.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person,Integer> {



}
