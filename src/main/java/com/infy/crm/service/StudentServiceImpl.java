package com.infy.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.infy.crm.entity.Student;
import com.infy.crm.exception.StudentException;
import com.infy.crm.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student findStudentById(Integer id) {
		Student student = studentRepo.findById(id).orElseThrow(()-> new StudentException("Student with id "+id+" not available", HttpStatus.NOT_FOUND));
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	@Transactional
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
	}

}
