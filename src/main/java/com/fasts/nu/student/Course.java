package com.fasts.nu.student;

public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private String teacherName;

    // Constructor
    public Course(String courseId, String courseName, int credits, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.teacherName = teacherName;
    }

    // Getters
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getTeacherName() { return teacherName; }

    // Setters
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}