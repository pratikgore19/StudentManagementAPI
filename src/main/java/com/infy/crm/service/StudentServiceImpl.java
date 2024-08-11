package com.infy.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.crm.entity.Student;
import com.infy.crm.repository.StudentDao;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student findStudentById(Integer id) {
		return studentDao.findById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public void deleteStudentById(Integer id) {
		studentDao.delete(id);
	}

}
