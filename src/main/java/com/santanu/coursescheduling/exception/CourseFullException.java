package com.santanu.coursescheduling.exception;

public class CourseFullException extends Exception{
    public CourseFullException(String msg){
        super(msg);
    }
}