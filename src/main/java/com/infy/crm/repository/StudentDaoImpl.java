package com.infy.crm.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.crm.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public Integer delete(Integer id) {
		int rowsDeleted = entityManager.createQuery("delete from Student where id = :id").setParameter("id", id).executeUpdate();
		return rowsDeleted;
	}

}
