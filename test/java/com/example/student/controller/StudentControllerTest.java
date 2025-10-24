package com.example.student.controller;
import com.example.student.Model.Student;
import com.example.student.Controller.StudentController;
import com.example.student.Service.StudentService;
import com.example.student.constants.APIConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = com.example.student.StudentApplication.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("kowshik");
        student.setAge("22");
        student.setEmail("kowshik@gmail.com");
        when(service.createStudent(any(Student.class))).thenReturn(student);
        mockMvc.perform(post("/students")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("kowshik"));
    }
    @Test
    void testGetAllStudents() throws Exception {
        Student s1 = new Student();
        s1.setId(1L);
        s1.setName("John");
        s1.setEmail("john@example.com");
        s1.setAge("22");
        Student s2 = new Student();
        s2.setId(2L);
        s2.setName("Alice");
        s2.setEmail("alice@example.com");
        s2.setAge("21");

        when(service.getAllStudents()).thenReturn(Arrays.asList(s1, s2));

        mockMvc.perform(get(APIConstants.STUDENTS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testUpdateStudent() throws Exception {
        Student stud = new Student();
        stud.setId(1L);
        stud.setName("kowshik");
        stud.setEmail("kowshik@gmail.com");
        stud.setAge("22");

        when(service.updateStudent(eq(1L), any(Student.class))).thenReturn(stud);

        mockMvc.perform(put(APIConstants.CallingStudents)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stud)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("kowshik"))
                .andExpect(jsonPath("$.email").value("kowshik@gmail.com"));
    }

    @Test
    void testDeleteStudent() throws Exception {
        Long studentId = 1L;

        doNothing().when(service).deleteStudent(studentId);

        mockMvc.perform(delete("/students/{id}", studentId))
                .andExpect(status().isOk());
    }



}
