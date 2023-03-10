package com.santanu.coursescheduling;

import com.santanu.coursescheduling.exception.InvalidInputException;
import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.concrete.LearningManagementSystem;
import com.santanu.coursescheduling.service.FileProcesserService;

import java.io.FileNotFoundException;
import java.io.IOException;


public class CourseSchedulingApp {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Intuit");
                FileProcesserService fileProcesserService = new FileProcesserService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
