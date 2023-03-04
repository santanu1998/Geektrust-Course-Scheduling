package com.santanu.coursescheduling.service;

import com.santanu.coursescheduling.exception.CourseFullException;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;

import java.util.Map;
import java.util.TreeMap;

public interface CommandExecutor {
    void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}
