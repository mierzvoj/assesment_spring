package pl.com.pjatk.mpr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;

import java.util.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findCourseByCourseName(String courseName);
}
