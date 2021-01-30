package pl.com.pjatk.mpr.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import pl.com.pjatk.mpr.model.*;

import java.util.*;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentId(String studentId);

    @Query("SELECT s from  Student s where s.id = :courseName")
    Optional<Student> getStudentByCourseName(String courseName);

}
