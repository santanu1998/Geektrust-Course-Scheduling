package com.example.geektrust.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.santanu.coursescheduling.concrete.CommandExecutionFactory;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.service.CommandService;
import com.santanu.coursescheduling.service.CourseCommandExecutor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RegisterCourseCommandExecutorImplTest {
    Command command1;
    Command command2;
    CourseCommandExecutor executor1;
    CourseCommandExecutor executor2;
    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = CommandService.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        executor1 =CommandExecutionFactory.getExecutor(command1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        executor2 = CommandExecutionFactory.getExecutor(command2);
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()->executor2.executeCourseCommand(courses , registrationIdCourseMap , command2));
    }



}
