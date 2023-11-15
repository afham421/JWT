package com.jwt.Repository;

import com.jwt.entity.Person;
import com.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegiserDao extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
