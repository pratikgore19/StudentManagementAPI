package com.infy.crm.repository;

import java.util.List;

import com.infy.crm.entity.Student;

public interface StudentDao {
	Student save(Student student);
	Student findById(Integer id);
	List<Student> findAll();
	void delete(Integer id);
}
