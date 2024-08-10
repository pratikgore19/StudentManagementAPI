package com.infy.crm.repository;

import java.util.List;

import com.infy.crm.entity.Student;

public interface StudentDao {
	void save(Student student);
	Student findById(Integer id);
	List<Student> findAll();
	Integer delete(Integer id);
}
