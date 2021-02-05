package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "course", orphanRemoval = true, targetEntity = Student.class)

    private List<Student> students = new ArrayList<>();


    public Course() {
    }
    public Course(String courseName) {
        this.courseName = courseName;

    }
    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
