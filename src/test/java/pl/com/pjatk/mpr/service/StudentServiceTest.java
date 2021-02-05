package pl.com.pjatk.mpr.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import pl.com.pjatk.mpr.model.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private CourseService;
    @Mock
    private GradeService;
    @InjectMocks
    private StudentService;

    @BeforeEach
    void setUp(){}

    Student student1 = new Student("firstname1", "secondname1", "course1", "hallo");



}
