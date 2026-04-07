package com.fasts.nu.student;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("T001", "Dr. Ahmed", "ahmed@nu.edu.pk");
    }

    @Test
    void should_returnCorrectId_when_teacherCreated() {
        assertEquals("T001", teacher.getTeacherId());
    }

    @Test
    void should_returnCorrectName_when_teacherCreated() {
        assertEquals("Dr. Ahmed", teacher.getName());
    }

    @Test
    void should_returnCorrectEmail_when_teacherCreated() {
        assertEquals("ahmed@nu.edu.pk", teacher.getEmail());
    }

    @Test
    void should_returnEmptyList_when_noCoursesAdded() {
        assertEquals(0, teacher.getCoursesTaught().size());
    }

    @Test
    void should_addCourse_when_courseProvided() {
        Course course = new Course("CS101", "Programming", 3, "Dr. Ahmed");
        teacher.addCourse(course);
        assertEquals(1, teacher.getCoursesTaught().size());
    }

    @Test
    void should_returnCorrectCourseCount_when_multipleCoursesAdded() {
        Course c1 = new Course("CS101", "Programming", 3, "Dr. Ahmed");
        Course c2 = new Course("CS102", "Data Structures", 4, "Dr. Ahmed");
        teacher.addCourse(c1);
        teacher.addCourse(c2);
        assertEquals(2, teacher.getCoursesTaught().size());
    }
}