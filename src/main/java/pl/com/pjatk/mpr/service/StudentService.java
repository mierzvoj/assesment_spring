package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import javax.persistence.*;
import java.util.*;

@Service
public class StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    CourseService courseService;
    GradeService gradeService;


    public StudentService(StudentRepository studentRepository, CourseService courseService,
                          CourseRepository courseRepository, GradeService gradeService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.gradeService = gradeService;

    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        return studentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("This Student " + id +" does not exists"));
    }

    public Optional<Student> findByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId);
    }

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }


    public Optional<Student> findStudentByCourse(String courseName){
        return courseRepository.getStudentsByCourseName(courseName);
    }

    public Student averageCount(Long id){
        Student averageStudent = studentRepository.findById(id).get();
        studentRepository.save(gradeService.average(averageStudent));
        return studentRepository.save(averageStudent);

    }

    public List<Double> listBest(){
        return gradeService.listBestStudents();
    }


}
