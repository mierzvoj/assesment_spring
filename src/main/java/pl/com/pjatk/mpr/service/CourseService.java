package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import javax.persistence.*;
import java.util.*;
import java.util.regex.*;

@Service
public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    public Course saveCourse(Course course){
        course.getStudents().forEach(d -> d.setCourse(course));
        courseRepository.save(course);
        return course;
    }

    public Optional<Course> findByCourseName(String courseName){
        return courseRepository.findCourseByCourseName(courseName);
    }

}
