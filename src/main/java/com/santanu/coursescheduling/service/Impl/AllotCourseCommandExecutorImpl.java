package com.santanu.coursescheduling.service.Impl;

import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.model.Employee;
import com.santanu.coursescheduling.service.CommandExecutor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class AllotCourseCommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        String courseId = command.getCommandParams().get(0);
        Course course = courses.get(courseId);
        if(course!=null){
            if(course.getRegisteredEmployees().size()<course.getMinCapacity()){
                course.setCancelled(true);
                printCourseData(course);
            }else{
                course.setAllotted(true);
                printCourseData(course);
            }
        }else{
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void printCourseData(Course course) {
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String,Employee> e: course.getRegisteredEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey()+" "+e.getValue().getEmailAddress()+" "+course.getCourseID()+" "+course.getCourseName()+" "+course.getInstructor()+" "
                   + df.format(course.getDate())+" "+status);
        }
    }
}
