package com.newproject.courseservice.repository;

import com.newproject.datatype.dto.Course;
import com.newproject.datatype.dto.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class CourseRepository {
    private HashMap<Course, Professor> courseList = new HashMap<>();

    public Course addCourse(Course c, Professor p){
        courseList.put(c,p);
        return c;
    }

    public Course removeCourse(Course c){
        courseList.remove(c);
        return c;
    }

    public Set<Course> showAllCourses(){
        return courseList.keySet();
    }



}
