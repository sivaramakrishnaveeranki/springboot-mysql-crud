package com.example.springCrud.StudentController;


import java.util.List;

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

import com.example.springCrud.StudentEntity.Student;
import com.example.springCrud.StudentSevices.StudentServices;



@RestController
@RequestMapping("/api/students")
public class studentController {
	private StudentServices studentServices;
	public studentController(StudentServices studentServices) {
		this.studentServices=studentServices;
	}
	
    @PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
     Student creates =studentServices.createStudent(student);
     return ResponseEntity.status(HttpStatus.CREATED).body(creates);
	}
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
    	Student studentresponse=studentServices.getStudent(id);
    	if(studentresponse==null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    	return ResponseEntity.ok(studentresponse);  	
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
    	
    	List<Student> studentList=studentServices.getStudentList();
    	if(studentList.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(studentList);  	
    }   
    
    @PutMapping("/Update/{id}")
    public ResponseEntity<Student> upadteStudent(@PathVariable Long id,@RequestBody Student student){
    	Student studentresponse=studentServices.updateStudent(id,student);
    	if(studentresponse==null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    	return ResponseEntity.ok(studentresponse);  	
    }
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
    	boolean isDeleted=studentServices.deleteStudent(id);
    	
    	if(!isDeleted) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(true);
    }
}
