package com.example.Super.Admin.Controller;

import com.example.Super.Admin.dao.Student;
import com.example.Super.Admin.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/student")

public class StudentController{

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Value("${spring.application.name}")
    private String appName;


    @GetMapping
    public List<Student> getAllStudents(){
        log.info("Hitted here for all");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){

        return studentService.saveOrUpdateStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){

        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent !=null){
            existingStudent.setName(student.getName());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setPhonenumber(student.getPhonenumber());
            existingStudent.setDateofbirth(student.getDateofbirth());
            existingStudent.setAddress(student.getAddress());
            return studentService.saveOrUpdateStudent(existingStudent);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }


}



