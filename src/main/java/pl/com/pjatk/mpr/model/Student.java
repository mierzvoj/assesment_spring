package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;
import org.aspectj.bridge.*;

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

    private double grade1;
    private double grade2;
    private double grade3;
    private double grade4;
    private double grade5;

    private double averageGrade;
    private String message;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonIgnore
    public Course course;



    public Student() {
    }

    public Student(String studentId, String firstName, String secondName, Course course, String message) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.course = course;
        this.message = message;
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


    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public double getGrade4() {
        return grade4;
    }

    public void setGrade4(double grade4) {
        this.grade4 = grade4;
    }

    public double getGrade5() {
        return grade5;
    }

    public void setGrade5(double grade5) {
        this.grade5 = grade5;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    @JsonIgnore
    public double getSumOfGrades(){
        double sumOfGrades = grade1 + grade2 + grade3 + grade4 + grade5;
        return  sumOfGrades;
    }


}
