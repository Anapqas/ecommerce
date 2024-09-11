package com.avanade.avanade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avanade.avanade.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     
}
