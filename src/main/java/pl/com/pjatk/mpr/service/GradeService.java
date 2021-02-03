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

    private List<Double> bestAvg = new ArrayList<Double>();


    public GradeService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;


    }

    public static Student average(Student studentAvg) {
        double averageGrade = studentAvg.getSumOfGrades() / 5;
        studentAvg.setAverageGrade(averageGrade);
        return studentAvg;
    }

    public List<Double> listBestStudents() {
        bestAvg= studentRepository.findAll().stream()
                .map(Student::getAverageGrade)
               .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return bestAvg;

    }


}
