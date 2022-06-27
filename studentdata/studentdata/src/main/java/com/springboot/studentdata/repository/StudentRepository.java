package com.springboot.studentdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.studentdata.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

  @Query("select s from Student s where s.email = :email")
  public List<Student> checkEmail(@Param("email")String email);

  @Query("select s from Student s, Attendance a where s.standard=9 AND a.day=30 AND a.isPresent='false' AND s.id = a.student_id")
  List<Student> filterByDays();

  @Query("select s from Student s, Attendance a where s.city='ujjain' AND a.day=1 AND a.isPresent='true' AND s.id = a.student_id")
  List<Student> getAllStudentFromCity();

}
