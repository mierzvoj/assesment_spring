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
    MessageService messageService;


    public StudentService(StudentRepository studentRepository, CourseService courseService,
                          CourseRepository courseRepository, GradeService gradeService, MessageService messageService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.gradeService = gradeService;
        this.messageService = messageService;

    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        return studentRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

    public Student findByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId)
                .orElseThrow(RuntimeException::new);

    }

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);

    }

    public Optional<Student> findStudentByCourse(String courseName){
        return courseRepository.getStudentsByCourseName(courseName);
    }

    public Student averageCount(Long id){
        Student averageStudent = studentRepository.findById(id).get();
        studentRepository.save(gradeService.average(averageStudent));
        return studentRepository.save(averageStudent);

    }
    public Student textToStudent(Long id, String message){
        Student receiver = studentRepository.findById(id).get();
        studentRepository.save(messageService.textToStudent(receiver, message));
        return studentRepository.save(receiver);
    }


    public List<Student> listBest(){
        return gradeService.listBestStudents();
    }


    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
