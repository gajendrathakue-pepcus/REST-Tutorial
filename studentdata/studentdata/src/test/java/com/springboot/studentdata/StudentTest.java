package com.springboot.studentdata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.studentdata.model.Student;
import com.springboot.studentdata.repository.StudentRepository;
import com.springboot.studentdata.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

  @InjectMocks
  private StudentService studentService;
  @MockBean
  private StudentRepository studentRepository;

  @Test
  public void testSaveStudent() {
    Student student = new Student(1, "raman", "mumbai", 10, "raman@gmail.com");
    // student.setId(1);
    // student.setName("gajendra");
    // student.setCity("sehore");
    // student.setStandard(10);
    // student.setEmail("gajenthakur@gmail.com");

    // Mockito.when(studentRepository.save(student)).thenReturn(student);

    // assertThat(studentRepository.save(student)).isEqualTo(student);

    when(studentRepository.save(student)).thenReturn(student);
    assertEquals(student, studentService.saveStudent(student));

  }

  @Test
  public void getStudentTest() {
    when(studentRepository.findAll()).thenReturn(
        Stream.of(new Student(19, "radha", "ujjain", 12, "raxfju6@gmail.com")).collect(Collectors.toList()));
    assertEquals(1, studentService.getAllStudents().size());
  }

}
