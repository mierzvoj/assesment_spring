package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import java.util.*;

@Service
public class StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    CourseService courseService;
    GradeRepository gradeRepository;

    public StudentService(StudentRepository studentRepository, CourseService courseService, CourseRepository courseRepository,
                          GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.gradeRepository = gradeRepository;
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
        student.getGrades().forEach(d -> d.setGrade(student));
        studentRepository.save(student);
        return student;
    }


    public Optional<Student> findStudentByCourse(String courseName){
        return courseRepository.getStudentsByCourseName(courseName);
    }


}
