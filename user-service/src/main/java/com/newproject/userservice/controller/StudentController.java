package com.newproject.userservice.controller;

import com.newproject.datatype.dto.Student;
import com.newproject.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private UserRepository repository;

    @PostMapping
    public Student addStudent(@RequestBody Student s){
        LOGGER.info("Student add: {}",s);
        return repository.addStudent(s);
    }

    @GetMapping
    public List<Student> findAllStudents(){
        LOGGER.info("Student find");
        return repository.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Integer id){
        LOGGER.info("Student find: id={}", id);
        return repository.findStudById(id);
    }

}
