package com.springboot.studentdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.studentdata.exception.CustomException;
import com.springboot.studentdata.model.Attendance;
import com.springboot.studentdata.model.Student;
import com.springboot.studentdata.repository.AttendanceRepository;
import com.springboot.studentdata.repository.StudentRepository;

@Service
public class StudentService {
  
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  AttendanceRepository attendanceRepository;

  public Student saveStudent(Student student) {
    List<Student> studentCheck = studentRepository.checkEmail(student.getEmail());
   if(studentCheck.size() >= 1  && (studentCheck.get(0)).getEmail().equals(student.getEmail()))
   {
     throw new CustomException("Email already exist");
   }    
    return studentRepository.save(student);    
  }

  public List<Student> getAllStudents() {
    return (List<Student>) studentRepository.findAll();
  }

  public List<Student> filterByDays() {
    
    return studentRepository.filterByDays();
  }

  public List<Student> getAllStudentFromCity() {
    List<Student> student= studentRepository.getAllStudentFromCity();
   System.out.println(student);
    return studentRepository.getAllStudentFromCity();
  }

//  public Student saveStudent(Student student) {
//    
//    return studentRepository.save(student);
//  }
  }


