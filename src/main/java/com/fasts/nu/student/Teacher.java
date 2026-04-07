package com.fasts.nu.student;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String teacherId;
    private String name;
    private String email;
    private List<Course> coursesTaught;

    // Constructor
    public Teacher(String teacherId, String name, String email) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.coursesTaught = new ArrayList<>();
    }

    // Getters
    public String getTeacherId() { return teacherId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Course> getCoursesTaught() { return coursesTaught; }

    // Add course to teacher's list
    public void addCourse(Course course) {
        coursesTaught.add(course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", coursesTaught=" + coursesTaught.size() +
                '}';
    }
}