package com.fasts.nu.student;

import java.time.LocalDate;

public class Enrollment {

    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String status;   // e.g., "Active", "Completed", "Dropped"

    // Constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.status = "Active";
    }

    // Getters
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public String getStatus() { return status; }

    // Setters
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student.getName() +
                ", course=" + course.getCourseName() +
                ", date=" + enrollmentDate +
                ", status='" + status + '\'' +
                '}';
    }
}