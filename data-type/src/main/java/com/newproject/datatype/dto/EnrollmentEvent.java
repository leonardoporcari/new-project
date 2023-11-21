package com.newproject.datatype.dto;

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
