package com.santanu.coursescheduling.concrete;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.santanu.coursescheduling.exception.CourseFullException;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.service.CourseCommandExecutor;

public class CourseScheduler {

    private final TreeMap<String , Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public CourseScheduler(String name) {
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CourseCommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCourseCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
}
