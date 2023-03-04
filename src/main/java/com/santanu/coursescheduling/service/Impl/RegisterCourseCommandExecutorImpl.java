package com.santanu.coursescheduling.service.Impl;

import java.util.Map;
import java.util.TreeMap;

import com.santanu.coursescheduling.exception.CourseFullException;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.model.Employee;
import com.santanu.coursescheduling.service.CourseCommandExecutor;
import static com.santanu.coursescheduling.constants.CourseConstants.STATUS_REJECTED;
import static com.santanu.coursescheduling.constants.CourseConstants.STATUS_ACCEPTED;

public class RegisterCourseCommandExecutorImpl implements CourseCommandExecutor {

    @Override
    public void executeCourseCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException {
        String courseID = command.getParams().get(1);
        Employee employee = ConstructEmployeeObject(command);
        if(courses.containsKey(courseID)){
            Course course = courses.get(courseID);
            if(!courses.get(courseID).isAllotted() || courses.get(courseID).isCancelled()){
                if(course.getRegisteredEmployees().size()==course.getMinimumCapacity()){
                    throw new CourseFullException("COURSE_FULL_ERROR");
                }else{
                    //register the employee to course......
                    registerEmployeeToCourse(employee , course ,registrationIdCourseMap);
                }
            }else{
                //In case of course is allotted already
                System.out.println("REG-COURSE-"+employee.getName()+"-"+courses.get(courseID).getName()+" "+ STATUS_REJECTED);
            }
        }else{
            //In case of course ID is not present in the course offering list.
            System.out.println("INPUT_DATA_ERROR");
        }

    }

    private void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap) {
        String regID = course.addEmployee(employee);
        registrationIdCourseMap.put(regID , course);
        System.out.println(regID+" "+ STATUS_ACCEPTED);
    }

    private Employee ConstructEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getParams().get(0));
    }
}