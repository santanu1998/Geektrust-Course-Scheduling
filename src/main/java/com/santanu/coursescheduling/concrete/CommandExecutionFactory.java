package com.santanu.coursescheduling.concrete;

import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.service.CommandExecutor;
import com.santanu.coursescheduling.service.Impl.AddCourseCommandExecutorImpl;
import com.santanu.coursescheduling.service.Impl.AllotCourseCommandExecutorImpl;
import com.santanu.coursescheduling.service.Impl.CancelCourseCommandExecutorImpl;
import com.santanu.coursescheduling.service.Impl.RegisterCourseCommandExecutorImpl;

public class CommandExecutionFactory {
    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseCommandExecutorImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseCommandExecutorImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseCommandExecutorImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseCommandExecutorImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}