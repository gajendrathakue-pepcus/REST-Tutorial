package com.springboot.studentdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.studentdata.model.Attendance;
import com.springboot.studentdata.model.Student;
import com.springboot.studentdata.service.AttendanceService;
import com.springboot.studentdata.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @Autowired
  AttendanceService attendanceService;

  @PostMapping("/")
  public Student saveStudent(@RequestBody @Valid Student student) {
    Student studentResponse = studentService.saveStudent(student);
    return studentResponse;
  }

  @PostMapping("/file")
  public List<Attendance> saveAttandance(MultipartFile file) {

    return attendanceService.addAttendance(file);
  }

  @GetMapping("/")
  public List<Student> showStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/filterbydays")
  public List<Student> filterBydays() {

    return studentService.filterByDays();
 }
  @GetMapping("/getstudent")
  public List<Student> getAllStudentFromCity() {

    return studentService.getAllStudentFromCity();
  }
}