package com.example.geektrust.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.santanu.coursescheduling.concrete.CommandExecutionFactory;
import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.service.CommandService;
import com.santanu.coursescheduling.service.Impl.AddCourseCommandExecutor;

public class CommandExecutionFactoryTest {

    Command command1 ;
    Command command2 ;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = CommandService.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }

    @Test
    public void getExecutorTest() {
       Assertions.assertTrue(CommandExecutionFactory.getExecutor(command1) instanceof AddCourseCommandExecutor);
       Assertions.assertFalse(CommandExecutionFactory.getExecutor(command2) instanceof AddCourseCommandExecutor);
    }



}
