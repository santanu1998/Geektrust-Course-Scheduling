package com.example.geektrust.constants;

import org.junit.jupiter.api.Test;

import com.santanu.coursescheduling.constants.CourseConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstantsTest {

    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",CourseConstants.getFormattedValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",CourseConstants.getFormattedValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",CourseConstants.STATUS_ACCEPTED);
    }



}
