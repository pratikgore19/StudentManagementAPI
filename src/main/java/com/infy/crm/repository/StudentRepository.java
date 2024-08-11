package com.infy.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.crm.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
