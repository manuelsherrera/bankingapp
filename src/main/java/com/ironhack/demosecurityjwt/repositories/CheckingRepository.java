package com.ironhack.demosecurityjwt.repositories;

import com.ironhack.demosecurityjwt.models.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
