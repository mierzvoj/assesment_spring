package pl.com.pjatk.mpr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;

import java.util.*;
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

//    @Query("SELECT g from  Grade g where g.id = :studentId")
//    Grade getStudentGrade(String studentId);

}
