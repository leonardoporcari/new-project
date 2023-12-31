package com.newproject.userservice.controller;

import com.newproject.datatype.dto.Professor;
import com.newproject.datatype.dto.Student;
import com.newproject.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user/professor")
public class ProfessorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    private UserRepository repository;

    @PostMapping
    public Professor addProfessor(@RequestBody Professor p){
        LOGGER.info("Professor add: {}",p);
        return repository.addProfessor(p);
    }

    @GetMapping
    public Set<Professor> findAllProfessor(){
        LOGGER.info("Professor find");
        return repository.findAllProfessors();
    }

    //TODO: check if the print is correctly shown  although it should e printed client side
    @GetMapping("/{id}") //Personal information about professor
    public Professor findProfById(@PathVariable("id") Integer id){
        LOGGER.info("Professor find: id={}", id);
        return repository.findProfById(id);
    }
}
