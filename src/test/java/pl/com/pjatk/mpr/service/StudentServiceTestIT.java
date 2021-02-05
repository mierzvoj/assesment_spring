package pl.com.pjatk.mpr.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import pl.com.pjatk.mpr.model.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.*;

@SpringBootTest
public class StudentServiceTestIT {

    @Autowired
    private StudentService studentService;

    @AfterEach
    void cleanUP(){
        studentService.deleteAll();
    }
    @Test
    void shouldNotFindStudents(){
        List<Student> all = studentService.findAll();
        assertThat(all).isEmpty();
    }

    @Test
    void shouldFindStudents(){
        List<Student> all = studentService.findAll();
        assertThat(all).isNotEmpty();
    }

    @Test
    void shouldAddStudent(){
        Student student = studentService.saveStudent(new Student("s1"));
        assertThat(student.getId()).isPositive();
    }

    @Test
    void shouldFindStudentById(){
        Student student = studentService.saveStudent(new Student());
        assertThat(studentService.findById(1L).getId()).isEqualTo(1L);
        studentService.deleteStudent(1L);
    }

    @Test
    void shouldThrowRuntimeException(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() ->studentService.findById(3L));
    }
}
