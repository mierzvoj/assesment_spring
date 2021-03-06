package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double gradeA;
    private double gradeB;


    @OneToOne(mappedBy = "grade")
    @JsonIgnore
    private Student student;

    public Grade() {
    }

    public Grade(double gradeA, double gradeB) {
        this.gradeA = gradeA;
        this.gradeB = gradeB;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGradeA() {
        return gradeA;
    }

    public void setGradeA(double gradeA) {
        this.gradeA = gradeA;
    }

    public double getGradeB() {
        return gradeB;
    }

    public void setGradeB(double gradeB) {
        this.gradeB = gradeB;
    }
}

