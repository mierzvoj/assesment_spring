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


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
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
    void findAll() {
        //Given
        when(studentRepository.findAll()).thenReturn(List.of(new Student()));
        //When
        List<Student> all = studentService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void saveStudent() {
        //Given
        Student p1 = new Student(1L, "f1", "sec1", new Course("c1") ,  "hallo");
        Student p2 = new Student(2L, "f2", "sec2", new Course("c2") ,  "hallo1");
        //When
        when(studentRepository.save(p1)).thenReturn(p2);
        //Then
       assertThat(studentService.saveStudent(p1).getId()).isEqualTo(p2.getId());

    }

    @Test
    void averageCount(){
        Student p1 = new Student(1L, "f1", "sec1", new Course("c1") ,  "hallo");
        p1.setGrade1(5);
        p1.setGrade2(5);
        p1.setGrade3(5);
        p1.setGrade4(5);
        p1.setGrade5(5);
        when(studentService.averageCount(any())).thenCallRealMethod();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(p1));
        when(studentRepository.save(p1)).thenReturn(p1);
        studentService.averageCount(p1.getId());
        assertThat(p1.getAverageGrade()).isEqualTo(5.0);
    }

    @Test
    void shouldDelete(){
        studentService.deleteStudent(1L);
        studentService.deleteStudent(2L);
        studentService.deleteStudent(2L);
        studentService.deleteStudent(4L);
        studentService.deleteStudent(5L);
        verify(studentRepository, times(2)).deleteById(2L);
    }
}
