package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import java.util.*;

@Service
public class StudentService {

    StudentRepository studentRepository;
    CourseService courseService;

    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId);
    }

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student assignStudentToACourse(String studentId){

        Student studentAssigned = studentRepository.findByStudentId(studentId).get();

        studentAssigned = CourseService.assignCourse(studentAssigned);

        return studentRepository.save(studentAssigned);
    }



}
