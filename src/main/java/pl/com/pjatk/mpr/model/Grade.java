package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double grade;



    @OneToOne(mappedBy = "grade")
    @JsonIgnore
    private Student student;

    public Grade() {
    }

    public Grade(double grade) {
        this.grade = grade;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

