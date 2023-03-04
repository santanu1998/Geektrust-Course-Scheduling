package com.santanu.coursescheduling.enums;

public enum CourseCommand {
    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);

    CourseCommand(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}
