package com.infy.crm.service;

import java.util.List;

import com.infy.crm.entity.Student;

public interface StudentService {
	Student saveStudent(Student student);
	Student findStudentById(Integer id);
	List<Student> findAllStudents();
	void deleteStudentById(Integer id);
}
