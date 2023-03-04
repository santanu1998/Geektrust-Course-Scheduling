package com.santanu.coursescheduling.service.Impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.service.CourseCommandExecutor;

public class AddCourseCommandExecutor implements CourseCommandExecutor {

    @Override
    public void executeCourseCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getParams();
        Course course = constructCourseObject(params);
        addCourseToSchedule(courses , course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date startDate = inputFormat.parse(params.get(2));
            int minCount = Integer.parseInt(params.get(3));
            int maxCount = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , startDate ,minCount , maxCount , false, false);
        }catch (Exception e){
            throw new InvalidInputException("Invalid input provided");
        }
        return course;
    }

    private void addCourseToSchedule(TreeMap<String, Course> courses, Course course){
        courses.put(course.getId(),course);
        System.out.println(course.getId());
    }
}
