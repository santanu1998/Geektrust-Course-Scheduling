package com.santanu.coursescheduling.concrete;

import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.service.CourseCommandExecutor;
import com.santanu.coursescheduling.service.Impl.AddCourseCommandExecutor;
import com.santanu.coursescheduling.service.Impl.CancelCourseCommandExecutorImpl;
import com.santanu.coursescheduling.service.Impl.RegisterCourseCommandExecutorImpl;
import com.santanu.coursescheduling.service.Impl.AllotCourseExecutorImpl;

public class CommandExecutionFactory {
    public static CourseCommandExecutor getExecutor(Command task) {
        CourseCommandExecutor executor = null;
        if(task!=null){
            switch(task.getCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseCommandExecutor();
                    break;
                case CANCEL:
                    executor = new CancelCourseCommandExecutorImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseExecutorImpl();
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
