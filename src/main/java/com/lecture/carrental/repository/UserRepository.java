package com.lecture.carrental.repository;

import com.lecture.carrental.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lecture.carrental.exception.ResourceNotFoundException;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <User, Long>{

//    @Query("Select u from user where u.email=?1")
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email) throws ResourceNotFoundException;
}
