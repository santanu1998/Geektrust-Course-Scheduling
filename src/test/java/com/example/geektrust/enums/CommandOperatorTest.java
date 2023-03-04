package com.example.geektrust.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.santanu.coursescheduling.enums.CourseCommand;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;

public class CommandOperatorTest {

    Integer registerValue;
    Integer courseOfferingValue;

    @BeforeEach
    public void setup(){
        registerValue = 2;
        courseOfferingValue = 5;
    }
    @Test
    public void testGetNumberOfArguments() {
        assertEquals(Optional.of(CourseCommand.REGISTER.getNumberOfArguments()).get(),registerValue);
        assertEquals(Optional.of(CourseCommand.ADD_COURSE_OFFERING.getNumberOfArguments()).get(),courseOfferingValue);
    }
}
