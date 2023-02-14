package com.ironhack.demosecurityjwt.repositories;

import com.ironhack.demosecurityjwt.models.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
