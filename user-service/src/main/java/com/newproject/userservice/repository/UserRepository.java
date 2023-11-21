package com.newproject.userservice.repository;

import com.newproject.datatype.dto.Course;
import com.newproject.datatype.dto.Professor;
import com.newproject.datatype.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {
    private HashMap<Student, List<Course>> studentsCourses= new HashMap<>();
    private HashMap<Professor, List<Course>> professorsCourses= new HashMap<>();

    public Student addStudent(Student s){
        studentsCourses.put(s, new ArrayList<Course>());
        return s;
    }

    public Student findStudById(Integer id){
        return studentsCourses.keySet().stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Set<Student> findAllStudents(){
        return studentsCourses.keySet();
    }

    public void addCourseForStud(Student s, Course c){
        //maybe useless if, but for now i keep it
        if(!studentsCourses.containsKey(s)) studentsCourses.put(s, new ArrayList<Course>());
        studentsCourses.get(s).add(c);
    }

    public Professor addProfessor(Professor p){
        professorsCourses.put(p, new ArrayList<Course>());
        return p;
    }

    public Professor findProfById(Integer id){
        Professor p = professorsCourses.keySet().stream()
                .filter(professor ->professor.getId().equals(id))
                .findFirst()
                .orElse(null);
        System.out.println(p + "\nCourses held: "+ professorsCourses.get(p));
        return p;
    }

    public Set<Professor> findAllProfessors(){
        return professorsCourses.keySet();
    }
}
