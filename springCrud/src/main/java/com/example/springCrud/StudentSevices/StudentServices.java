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
		studentRepo.setDeleted(false);
		Student studentresponse=studentRepository.save(studentRepo);
		return studentresponse;
	}
	
	
	//select * from student where id=1 and deleted=false
	public Student getStudent(Long id) {
		Optional<Student> studentResponse=studentRepository.findByIdAndDeletedIsFalse(id);
		
		if(studentResponse.isPresent()) {
			return studentResponse.get();
		}
		return null;	
	}
   
	
	//select  * from student where deleted=false
   public List<Student> getStudentList(){
	  List<Student> studentList= studentRepository.findByDeletedIsFalse();
	  return studentList;
	 }
   
   public Student updateStudent(Long id,Student studentReq) {
	   Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
	   if(existingStudent.isEmpty()) {
		   return null;
	   }
	   Student studentTosave=existingStudent.get();
	   
	   studentTosave.setName(studentReq.getName());
	   studentTosave.setAge(studentReq.getAge());
	   studentTosave.setEmail(studentReq.getEmail());
	   studentTosave.setRollNo(studentReq.getRollNo());
	   studentTosave.setSubject(studentReq.getSubject());
	   studentTosave.setDeleted(false);
	   
	   return studentRepository.save(studentTosave);
   }
   
   //select * from
   public boolean deleteStudent(Long id) {
	   boolean isStudent=studentRepository.existsById(id);
	   if(!isStudent) {
		   return false;
	   }
	   studentRepository.deleteById(id);
	   return true;   
   }
   
   public boolean deleteStudentSoft(Long id) {
	   Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
	   if(existingStudent.isEmpty()) {
		   return false;
	   }
	   Student studentToSave=existingStudent.get();
	   studentToSave.setDeleted(true);
	   studentRepository.save(studentToSave);
	   return true;
   }
   
}
