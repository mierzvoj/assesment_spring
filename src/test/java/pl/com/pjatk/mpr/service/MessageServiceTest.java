package pl.com.pjatk.mpr.service;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.util.*;


import java.util.*;
@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {
    @Mock
    private CourseService courseService;
    @Mock
    private GradeService gradeService;
    @Mock
    private MessageService messageService;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp(){}

    @Test
    void messaging(){
        Student p1 = new Student(1L, "f1", "sec1"
                , new Course("c1"), "" );

        when(studentRepository.findById(1L)).thenReturn(Optional.of(p1));
        when(studentRepository.save(p1)).thenReturn(p1);
        studentService.textToStudent(1L, "hallo");
        Assertions.assertEquals(p1.getMessage(),"hallo");
    }

}
