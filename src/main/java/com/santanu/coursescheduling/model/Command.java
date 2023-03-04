package com.santanu.coursescheduling.model;

import java.util.List;

import com.santanu.coursescheduling.enums.CourseCommand;

public class Command {
    private final CourseCommand command;
    private final List<String> params;

    public Command(CourseCommand command, List<String> params){
        this.command = command;
        this.params = params;
    }

    public CourseCommand getCommand() {
        return command;
    }

    public List<String> getParams() {
        return params;
    }
}
