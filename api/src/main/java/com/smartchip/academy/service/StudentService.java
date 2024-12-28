package com.smartchip.academy.service;

import com.smartchip.academy.dao.Student;
import com.smartchip.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveOrUpdateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
