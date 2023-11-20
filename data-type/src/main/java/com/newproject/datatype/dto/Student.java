package com.newproject.datatype.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data //getters and setters
public class Student {

    private Integer id;
    private String name;
    private List<Course> coursesAttended= new ArrayList<>();

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCourse(Course c){
        coursesAttended.add(c);
    }
}
