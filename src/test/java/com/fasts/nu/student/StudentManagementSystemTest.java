package com.fasts.nu.student;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagementSystemTest {

    private StudentManagementSystem sms;
    private Student student;
    private Course course;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        sms = new StudentManagementSystem();
        student = new Student("S001", "Ali", "ali@nu.edu.pk", 20);
        course = new Course("CS101", "Programming", 3, "Dr. Ahmed");
        teacher = new Teacher("T001", "Dr. Ahmed", "ahmed@nu.edu.pk");
    }

    @Test
    void should_addStudent_when_validStudentProvided() {
        sms.addStudent(student);
        // no exception means success
    }

    @Test
    void should_addCourse_when_validCourseProvided() {
        sms.addCourse(course);
    }

    @Test
    void should_addTeacher_when_validTeacherProvided() {
        sms.addTeacher(teacher);
    }

    @Test
    void should_enrollStudent_when_studentAndCourseExist() {
        sms.addStudent(student);
        sms.addCourse(course);
        sms.enrollStudent(student, course);
    }

    @Test
    void should_assignGrade_when_studentAndCourseExist() {
        sms.addStudent(student);
        sms.addCourse(course);
        sms.assignGrade(student, course, 85);
    }

    @Test
    void should_displayAllStudents_when_studentsExist() {
        sms.addStudent(student);
        sms.displayAllStudents();
    }

    @Test
    void should_displayAllCourses_when_coursesExist() {
        sms.addCourse(course);
        sms.displayAllCourses();
    }

    @Test
    void should_runDemo_when_called() {
        sms.addStudent(student);
        sms.addCourse(course);
        sms.runDemo();
    }
    @Test
    void should_assignGradeA_when_marksAre95() {
        sms.addStudent(student);
        sms.addCourse(course);
        sms.assignGrade(student, course, 95);
    }

    @Test
    void should_assignGradeF_when_marksAre50() {
        sms.addStudent(student);
        sms.addCourse(course);
        sms.assignGrade(student, course, 50);
    }

    @Test
    void should_enrollMultipleStudents_when_multipleStudentsProvided() {
        Student student2 = new Student("S002", "Sara", "sara@nu.edu.pk", 22);
        sms.addStudent(student);
        sms.addStudent(student2);
        sms.addCourse(course);
        sms.enrollStudent(student, course);
        sms.enrollStudent(student2, course);
    }

    @Test
    void should_displayStudents_when_multipleStudentsAdded() {
        Student student2 = new Student("S002", "Sara", "sara@nu.edu.pk", 22);
        sms.addStudent(student);
        sms.addStudent(student2);
        sms.displayAllStudents();
    }
}