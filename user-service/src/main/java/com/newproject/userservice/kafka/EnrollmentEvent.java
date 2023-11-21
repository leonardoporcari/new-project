package com.newproject.userservice.kafka;

import com.newproject.datatype.dto.Course;
import com.newproject.datatype.dto.Student;

public class EnrollmentEvent {
    private Student stud;
    private Course course;

    public EnrollmentEvent(Student stud, Course course) {
        this.stud = stud;
        this.course = course;
    }

    public Student getStud() {
        return stud;
    }

    public Course getCourse() {
        return course;
    }
}
