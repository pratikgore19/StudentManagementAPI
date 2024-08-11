package com.infy.crm.api;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.crm.entity.Student;
import com.infy.crm.exception.StudentException;
import com.infy.crm.service.StudentService;
import com.infy.crm.utitlity.ResponseBody;

@RestController
@RequestMapping("/students")
public class StudentApi {
	
	@Autowired
	StudentService studentService;
	
	// Create student
	@PostMapping()
	public ResponseEntity<ResponseBody> addStudent(@RequestBody Student stud) {
		
		Student savedStudent = studentService.saveStudent(stud);
		ResponseBody response = new ResponseBody();
		response.setMessage("Student added succesfully with id "+savedStudent.getId());
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ResponseBody>(response, HttpStatus.CREATED);
	}
	
	// Retrieve student by id
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		Student stud = studentService.findStudentById(id);
		if(stud == null) {
			throw new StudentException("Student with id "+id+" not available", HttpStatus.NOT_FOUND);
		}
		return stud;
	}
	
	// Retrieve all students
	@GetMapping()
	public List<Student> getAllStudents() {
		List<Student> students = studentService.findAllStudents();
		if(students.size() <= 0) {
			throw new StudentException("No students are available in database. Kindly add students.", HttpStatus.BAD_REQUEST);
		}
		return students;
	}
	
	// Update student
		@PutMapping()
		public ResponseEntity<ResponseBody> updateStudent(@RequestBody Student stud) {
			
			Student updatedStudent = studentService.saveStudent(stud);
			ResponseBody response = new ResponseBody();
			response.setMessage("Student updated succesfully with id "+updatedStudent.getId());
			response.setStatusCode(HttpStatus.OK.value());
			response.setTimeStamp(LocalDateTime.now());
			
			return new ResponseEntity<ResponseBody>(response, HttpStatus.OK);
		}
	
	// Delete student by id
		@DeleteMapping("/{id}")
		public ResponseEntity<ResponseBody> deleteStudentById(@PathVariable Integer id) {
			Student stud = studentService.findStudentById(id);
			if(stud == null) {
				throw new StudentException("Student with id "+id+" not available", HttpStatus.NOT_FOUND);
			}
			ResponseBody response = new ResponseBody();
			response.setMessage("Student deleted succesfully with id "+stud.getId());
			response.setStatusCode(HttpStatus.OK.value());
			response.setTimeStamp(LocalDateTime.now());
			
			studentService.deleteStudentById(id);
			return new ResponseEntity<ResponseBody>(response, HttpStatus.OK);
		}
}
