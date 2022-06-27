package com.springboot.studentdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.studentdata.model.Attendance;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
