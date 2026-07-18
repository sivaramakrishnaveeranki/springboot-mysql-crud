package com.example.springCrud.StudentSevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springCrud.StudentEntity.Student;
import com.example.springCrud.StudentRespo.StudentRepository;


@Service
public class StudentServices {
	private StudentRepository studentRepository;
	public StudentServices(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	public Student createStudent(Student studentRepo) {
		Student studentresponse=studentRepository.save(studentRepo);
		return studentresponse;
	}
	
	public Student getStudent(Long id) {
		Optional<Student> studentResponse=studentRepository.findById(id);
		
		if(studentResponse.isPresent()) {
			return studentResponse.get();
		}
		return null;	
	}
	
   public List<Student> getStudentList(){
	  List<Student> studentList= studentRepository.findAll();
	  return studentList;
	 }
   
   public Student updateStudent(Long id,Student studentReq) {
	   Optional<Student> existingStudent=studentRepository.findById(id);
	   if(existingStudent.isEmpty()) {
		   return null;
	   }
	   Student studentTosave=existingStudent.get();
	   
	   studentTosave.setName(studentReq.getName());
	   studentTosave.setAge(studentReq.getAge());
	   studentTosave.setEmail(studentReq.getEmail());
	   studentTosave.setRollNo(studentReq.getRollNo());
	   studentTosave.setSubject(studentReq.getSubject());
	   return studentRepository.save(studentTosave);
   }
   public boolean deleteStudent(Long id) {
	   boolean isStudent=studentRepository.existsById(id);
	   if(!isStudent) {
		   return false;
	   }
	   studentRepository.deleteById(id);
	   return true;   
   }
}
