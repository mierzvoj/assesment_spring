package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String firstName;
    private String secondName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonIgnore
    public Course course;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "grades_id", referencedColumnName = "id")
    private List<Grade> grades = new ArrayList<>();


    public Student() {
    }

    public Student(String studentId, String firstName, String secondName, Course course, List<Grade> grades) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.course = course;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
