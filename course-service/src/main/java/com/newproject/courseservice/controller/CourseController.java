package com.newproject.courseservice.controller;

import com.newproject.courseservice.kafka.EnrollmentProducer;
import com.newproject.courseservice.repository.CourseRepository;
import com.newproject.datatype.dto.Course;
import com.newproject.datatype.dto.EnrollmentEvent;
import com.newproject.datatype.dto.Professor;
import com.newproject.datatype.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private EnrollmentProducer enrollmentProducer;

    @Autowired
    private CourseRepository repository;

    @GetMapping
    public Set<Course> showAllCourses(){
        LOGGER.info("Courses find");
        return repository.showAllCourses();
    }

    @GetMapping("{course}/{student}/enroll")
    public void enrollToCourse(@PathVariable Course c, Student s){
        LOGGER.info("Event sent to broker");
        enrollmentProducer.sendEvent(new EnrollmentEvent(s,c));
    }


    @PostMapping("/add")
    public Course addCourse(@RequestBody Course c, Professor p){
        LOGGER.info("Add course");
        return repository.addCourse(c,p);
        //TODO: use another producer to inform user service
    }




    @PostMapping("/remove")
    public Course removeCourse(@RequestBody Course c){
        LOGGER.info("Remove course");
        return repository.removeCourse(c);
        //TODO: use another producer to inform user service
    }


}
