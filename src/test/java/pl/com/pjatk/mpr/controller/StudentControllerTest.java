package pl.com.pjatk.mpr.controller;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;
import pl.com.pjatk.mpr.service.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;
    @Test
    void findAll() throws Exception{
        mockMvc.perform(get("/student"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldMatchContent() throws Exception{
        mockMvc.perform(get("/ctrl"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("This is your controller")));
    }

    @Test
    void shouldNotFindStudent() throws Exception{
        mockMvc.perform(get("/student/100000")).andExpect(status().isNotFound());

    }
    @Test
    void shouldFindStudent() throws Exception{
        studentService.saveStudent(new Student(1L, "f1", "sec1"
                ,new Course("c1"), "m" ));
        mockMvc.perform(get("/student/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"firstName\":\"f1\",\"secondName \": \"sec1 \", \"courseName\": " +
                        "\"c1 \", \"message \"m}")));

    }

}
