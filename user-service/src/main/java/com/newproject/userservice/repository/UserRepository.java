package com.newproject.userservice.repository;

import com.newproject.datatype.dto.Professor;
import com.newproject.datatype.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<Student> students = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

    public Student addStudent(Student s){
        students.add(s);
        return s;
    }

    public Student findStudById(Integer id){
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Student> findAllStudents(){
        return students;
    }

    public Professor addProfessor(Professor p){
        professors.add(p);
        return p;
    }

    public Professor findProfById(Integer id){
        return professors.stream()
                .filter(professor ->professor.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Professor> findAllProfessors(){
        return professors;
    }

}
