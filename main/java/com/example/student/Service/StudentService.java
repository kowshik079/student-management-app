package com.example.student.Service;
import lombok.extern.slf4j.Slf4j;
import com.example.student.Model.Student;
import com.example.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }
    public Student createStudent(Student student) {

        return repository.save(student);
    }

    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = repository.findById(id)
                .orElseThrow(() -> {
                    return new RuntimeException("Student not found");
                });
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);

    }
}
