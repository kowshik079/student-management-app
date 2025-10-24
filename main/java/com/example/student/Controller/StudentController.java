package com.example.student.Controller;
import com.example.student.constants.APIConstants;
import lombok.extern.slf4j.Slf4j;
import com.example.student.Model.Student;
import com.example.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(APIConstants.STUDENTS)
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @GetMapping
    public List<Student> readAll() {
        return studentService.getAllStudents();
    }

    @PutMapping(APIConstants.IDENTITY)
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping(APIConstants.IDENTITY)
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}