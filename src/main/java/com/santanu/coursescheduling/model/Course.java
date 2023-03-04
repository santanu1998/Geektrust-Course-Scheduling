package com.santanu.coursescheduling.model;

import java.util.*;

public class Course implements Comparable<Course> {
    private final String id;
    private final String name;
    private final String instructor;
    private final Date date;
    private final int minimumCapacity;
    private final int maximumCapacity;
    private boolean isAllotted;
    private boolean isCancelled;

    private final Map<String , Employee> registeredEmployees;


    public Course(String id, String name, String instructor, Date date, int minimumCapacity, int maximumCapacity, boolean isAllotted, boolean isCancelled) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.date = date;
        this.minimumCapacity = minimumCapacity;
        this.maximumCapacity = maximumCapacity;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        registeredEmployees = new TreeMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMinimumCapacity() {
        return minimumCapacity;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setAllotted(boolean isAllotted) {
        this.isAllotted = isAllotted;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Map<String, Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public String addEmployee(Employee employee){
        String registrationID = "REG-COURSE-" + employee.getName() + "-" + this.name;
        this.registeredEmployees.put(registrationID , employee);
        return registrationID;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}
