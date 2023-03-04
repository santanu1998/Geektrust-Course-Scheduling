package com.santanu.coursescheduling.service.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import com.santanu.coursescheduling.exception.CourseFullException;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.model.Employee;
import com.santanu.coursescheduling.service.CourseCommandExecutor;

public class AllotCourseExecutorImpl implements CourseCommandExecutor {
    // @Override
    // public void executeCourseCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
    //     String courseId = command.getParams().get(0);
    //     Course course = courses.get(courseId);
    //     if(course!=null){
    //         if(course.getRegisteredEmployees().size()<course.getMinimumCapacity()){
    //             course.setCancelled(true);
    //             printCourseData(course);
    //         }else{
    //             course.setAllotted(true);
    //             printCourseData(course);
    //         }
    //     }else{
    //         throw new InvalidInputException("INVALID_INPUT_DATA");
    //     }
    // }

    private void printCourseData(Course course) {
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String,Employee> e: course.getRegisteredEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmailAddress()+" "+course.getId()+" "+course.getName()+" "+course.getInstructor()+" "
                   + df.format(course.getDate())+" "+status);
        }
    }

    @Override
    public void executeCourseCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap,
        Command command) throws InvalidInputException, CourseFullException {
        String courseId = command.getParams().get(0);
        Course course = courses.get(courseId);
        if(course!=null){
            if(course.getRegisteredEmployees().size()<course.getMinimumCapacity()){
                course.setCancelled(true);
                printCourseData(course);
            }
            else{
                course.setAllotted(true);
                printCourseData(course);
            }
        }
        else{
            throw new InvalidInputException("INVALID_INPUT_DATA");
        }
    }
}
