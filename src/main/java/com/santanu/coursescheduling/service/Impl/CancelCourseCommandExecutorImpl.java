package com.santanu.coursescheduling.service.Impl;

import java.util.Map;
import java.util.TreeMap;

import com.santanu.coursescheduling.model.Command;
import com.santanu.coursescheduling.model.Course;
import com.santanu.coursescheduling.service.CourseCommandExecutor;
import static com.santanu.coursescheduling.constants.CourseConstants.CANCEL_STATUS_ACCEPTED;
import static com.santanu.coursescheduling.constants.CourseConstants.CANCEL_STATUS_REJECTED;

public class CancelCourseCommandExecutorImpl implements CourseCommandExecutor {
    @Override
    public void executeCourseCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) {
        String regId = command.getParams().get(0);
        if(isValidRegistrationID(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId + " " + CANCEL_STATUS_REJECTED);
            }else{
                //Remove the registration for the employee...
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+ CANCEL_STATUS_ACCEPTED);
            }
        }else{
            System.out.println(regId+" "+ CANCEL_STATUS_REJECTED);
        }
    }

    private void removeRegisteredEmployee(String regId, Map<String, Course> registrationIdCourseMap) {
        Course course = registrationIdCourseMap.get(regId);
        course.getRegisteredEmployees().remove(regId);
        registrationIdCourseMap.remove(regId);
    }

    private boolean isCourseNotAllotted(String regId, Map<String, Course> registrationIdCourseMap) {
        return registrationIdCourseMap.get(regId).isAllotted();
    }

    private boolean isValidRegistrationID(String regId, Map<String, Course> registrationIdCourseMap) {
        if(registrationIdCourseMap.get(regId)!=null){
            return true;
        }else{
            return false;
        }
    }
}
