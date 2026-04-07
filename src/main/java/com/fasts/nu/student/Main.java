package com.fasts.nu.student;

public class Main {

    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();

        // Create Students
        Student s1 = new Student("S001", "Ali Khan", "ali.khan@nu.edu.pk", 20);
        Student s2 = new Student("S002", "Sara Ahmed", "sara.ahmed@nu.edu.pk", 22);

        // Create Courses
        Course c1 = new Course("CS101", "Introduction to Programming", 3, "Dr. Ahmed");
        Course c2 = new Course("CS102", "Data Structures", 4, "Dr. Fatima");

        // Create Teachers
        Teacher t1 = new Teacher("T001", "Dr. Ahmed", "ahmed@nu.edu.pk");
        Teacher t2 = new Teacher("T002", "Dr. Fatima", "fatima@nu.edu.pk");

        // Add to system
        sms.addStudent(s1);
        sms.addStudent(s2);
        sms.addCourse(c1);
        sms.addCourse(c2);
        sms.addTeacher(t1);
        sms.addTeacher(t2);

        // Enroll students
        sms.enrollStudent(s1, c1);
        sms.enrollStudent(s2, c2);

        // Assign grades
        sms.assignGrade(s1, c1, 85);
        sms.assignGrade(s2, c2, 92);

        // Display everything
        sms.runDemo();

        System.out.println("\n🎉 Student Management System is working successfully!");
    }
}