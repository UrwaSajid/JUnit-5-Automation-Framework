package com.fasts.nu.student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {

    private List<Student> students;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Enrollment> enrollments;
    private List<Grade> grades;

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.enrollments = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    // Add Course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getCourseName());
    }

    // Add Teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher added: " + teacher.getName());
    }

    // Enroll student in a course
    public void enrollStudent(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        System.out.println(student.getName() + " enrolled in " + course.getCourseName());
    }

    // Assign grade
    public void assignGrade(Student student, Course course, double marks) {
        Grade grade = new Grade(student, course, marks);
        grades.add(grade);
        System.out.println("Grade assigned to " + student.getName() + " in " + course.getCourseName() + ": " + grade.getGradeLetter());
    }

    // Display all students
    public void displayAllStudents() {
        System.out.println("\n=== All Students ===");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Display all courses
    public void displayAllCourses() {
        System.out.println("\n=== All Courses ===");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // Simple demo method
    public void runDemo() {
        System.out.println("=== Student Management System Demo Started ===\n");
        displayAllStudents();
        displayAllCourses();
        System.out.println("\n=== Demo Completed ===");
    }
}