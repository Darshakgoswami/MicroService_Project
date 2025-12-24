package com.example.student_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping("/student") 
public class StudentController {
@Autowired
private StudentService studentService;
@PostMapping
public ResponseEntity<?> createStudent(@RequestBody Student student){
    return studentService.createStudent(student);
}
@GetMapping("/{id}")
public ResponseEntity<?> fetchStudentById(@PathVariable Long id){
    return studentService.fetchStudentById(id);
}
@GetMapping
public ResponseEntity<?> fetchAllStudents(){
    return studentService.fetchAllStudents();
}
@PutMapping("/{id}")
public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
 return studentService.updateStudent(id, student);
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
 return studentService.deleteStudent(id);
}
}