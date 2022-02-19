package com.lecture.carrental.repository;

import com.lecture.carrental.domain.Role;
import com.lecture.carrental.domain.enumeration.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(UserRole name);
}
