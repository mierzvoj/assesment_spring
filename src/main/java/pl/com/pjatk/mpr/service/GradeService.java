package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import java.util.*;

@Service
public class GradeService {
    GradeRepository gradeRepository;
    StudentRepository studentRepository;

    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    public Grade saveGrade(Grade grade){
        gradeRepository.save(grade);
        return grade;
    }

//    public Grade getGrades(String studentId){
//        return gradeRepository.getStudentGrade(studentId);
//    }

}
