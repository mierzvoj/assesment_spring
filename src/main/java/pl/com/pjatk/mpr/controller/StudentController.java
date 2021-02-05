package pl.com.pjatk.mpr.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;
import pl.com.pjatk.mpr.exception.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;
import pl.com.pjatk.mpr.service.*;

import java.util.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
//@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    private CourseService courseService;
    private GradeService gradeService;
    private MessageService messageService;

    public StudentController(StudentService studentService, CourseService courseService
            , GradeService gradeService, MessageService messageService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.gradeService = gradeService;
        this.messageService = messageService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }


    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
          return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> findByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(studentService.findByStudentId(studentId));
//        if (byStudentId.isPresent()) {
//            return ResponseEntity.ok(byStudentId.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @GetMapping("/student/calc/{id}")
    public ResponseEntity<Student> calculateAverage(@PathVariable Long id) {
      return ResponseEntity.ok(studentService.averageCount(id));
    }

    @GetMapping("/student/list")
    public ResponseEntity<List> findBestStudents() {
        return ResponseEntity.ok(studentService.listBest());
    }


    @GetMapping("/course")
    public ResponseEntity<List<Course>> findAllCourses() {
        return ResponseEntity.ok(courseService.findAll());

    }

    @PostMapping("/course")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {

        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    @GetMapping("/course/{courseName}")
    public ResponseEntity<Course> findByCourseId(@PathVariable String courseName) {
        Optional<Course> byCourseId = courseService.findByCourseName(courseName);
        if (byCourseId.isPresent()) {
            return ResponseEntity.ok(byCourseId.get());
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find the course");
        }
    }

    @GetMapping("/student/course/{courseName}")
    public ResponseEntity<Student> findCoursesWithStudentId(@PathVariable String courseName) {
        Optional<Student> byCourseName = studentService.findStudentByCourse(courseName);
        if (byCourseName.isPresent()) {
            return ResponseEntity.ok(byCourseName.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     @PostMapping("/txt/{studentId}/{message}")
     public ResponseEntity<Student> textToStudent(@PathVariable Long studentId, @PathVariable String message){
         return ResponseEntity.ok(studentService.textToStudent(studentId, message));
        }




}
