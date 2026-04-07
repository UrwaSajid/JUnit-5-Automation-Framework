package com.fasts.nu.student;

public class Grade {

    private Student student;
    private Course course;
    private double marks;
    private String gradeLetter;

    // Constructor
    public Grade(Student student, Course course, double marks) {
        this.student = student;
        this.course = course;
        this.marks = marks;
        this.gradeLetter = calculateGradeLetter(marks);
    }

    private String calculateGradeLetter(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public double getMarks() { return marks; }
    public String getGradeLetter() { return gradeLetter; }

    public void setMarks(double marks) {
        this.marks = marks;
        this.gradeLetter = calculateGradeLetter(marks);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "student=" + student.getName() +
                ", course=" + course.getCourseName() +
                ", marks=" + marks +
                ", grade='" + gradeLetter + '\'' +
                '}';
    }
}