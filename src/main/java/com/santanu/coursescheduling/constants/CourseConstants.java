package com.santanu.coursescheduling.constants;

import java.util.regex.Pattern;

public class CourseConstants {
    public static final Pattern VALID_EMAIL_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String STATUS_REJECTED = "REJECTED";
    public static final String STATUS_ACCEPTED = "ACCEPTED";
    public static final String CANCEL_STATUS_REJECTED = "CANCEL_REJECTED";
    public static final String CANCEL_STATUS_ACCEPTED = "CANCEL_ACCEPTED";

    public static String getFormattedValue(String input) {
        String formattedValue = "";
        switch (input) {
            case "ADD-COURSE-OFFERING":
                formattedValue = "ADD_COURSE_OFFERING";
                break;

            case "ALLOT-COURSE":
                formattedValue = "ALLOT_COURSE";
                break;

            default:
                formattedValue = input;
                break;
        }
        return formattedValue;
    }
}
