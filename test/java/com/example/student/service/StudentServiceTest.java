package com.example.student.service;

import com.example.student.Model.Student;
import com.example.student.Service.StudentService;
import com.example.student.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    public StudentRepository repository;

    @InjectMocks
    private StudentService service;

    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() {
        Student student=new Student();
        student.setName("kowshik");
        student.setAge("22");
        student.setEmail("kowshik@gmail.com");

        when(repository.save(student)).thenReturn(student);

        Student saved = service.createStudent(student);

        assertEquals("kowshik", saved.getName());
        verify(repository, times(1)).save(student);
    }

    @Test
    void testGetAllStudents() {
        Student s1 = new Student();
        s1.setName("John");
        s1.setAge("33");
        s1.setEmail("john@example.com");


        Student s2 = new Student();
        s2.setName("cena");
        s2.setAge("36");
        s2.setEmail("cena@example.com");

        when(repository.findAll()).thenReturn(Arrays.asList(s1, s2));
        List<Student> students = service.getAllStudents();

        assertEquals(2, students.size());
        assertEquals("John", students.get(0).getName());
    }

    @Test
    void testUpdateStudent() {
        Student existing = new Student();
        existing.setId(1L);
        existing.setName("Old Name");
        existing.setEmail("old@example.com");
        existing.setAge("20");

        Student updated = new Student();
        updated.setName("New Name");
        updated.setEmail("new@example.com");
        updated.setAge("25");

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

        Student result = service.updateStudent(1L, updated);

        assertEquals("New Name", result.getName());
        assertEquals("25", result.getAge());
    }

    @Test
    void testDeleteStudent() {
        Long id = 1L;
        service.deleteStudent(id);
        verify(repository, times(1)).deleteById(id);
    }
}

