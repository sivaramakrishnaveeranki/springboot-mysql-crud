package com.example.springCrud.StudentRespo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.example.springCrud.StudentEntity.Student;

//@component or @Repository- but interface cannot create object
public interface StudentRepository extends JpaRepository<Student, Long> {

}
