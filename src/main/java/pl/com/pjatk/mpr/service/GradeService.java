package pl.com.pjatk.mpr.service;

import java.util.ArrayList;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import java.util.*;
import java.util.stream.*;

@Service
public class GradeService {

    StudentRepository studentRepository;

    List<Student> students = new ArrayList<>();

    public GradeService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static Student average(Student studentAvg) {
        double averageGrade = studentAvg.getSumOfGrades() / 5;
        studentAvg.setAverageGrade(averageGrade);
        return studentAvg;
    }

    public List<Student> listBestStudents() {
        students = studentRepository.OrderByAverageGradeDesc();
        return students;

    }


}
