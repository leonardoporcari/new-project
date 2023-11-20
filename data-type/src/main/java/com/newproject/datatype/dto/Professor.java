package com.newproject.datatype.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Professor {
    private Integer id;
    private String name;
    private List<Course> coursesHeld = new ArrayList<>();

    public Professor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCourse(Course c){
        coursesHeld.add(c);
    }
}
