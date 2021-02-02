package pl.com.pjatk.mpr.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;
import pl.com.pjatk.mpr.service.*;

import java.util.*;

@RestController
//@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    private CourseService courseService;
    private GradeService gradeService;

    public StudentController(StudentService studentService, CourseService courseService, GradeService gradeService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.gradeService = gradeService;
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
        Optional<Student> byStudentId = studentService.findByStudentId(studentId);
        if (byStudentId.isPresent()) {
            return ResponseEntity.ok(byStudentId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
            return ResponseEntity.notFound().build();
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

    @PostMapping("/setgrade/{studentId}")
    public ResponseEntity<Student> saveGrades(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }




    @GetMapping("/getgrade/{studentId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId) {
        return ResponseEntity.ok(gradeService.getGrades(studentId));
    }
}
