package com.fasts.nu.student;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course;

    @BeforeEach
    void setUp() {
        course = new Course("CS101", "Programming", 3, "Dr. Ahmed");
    }

    // --- POSITIVE TESTS ---

    @Test
    @Tag("fast")
    void should_returnCorrectCourseId_when_courseCreated() {
        assertEquals("CS101", course.getCourseId());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectCourseName_when_courseCreated() {
        assertEquals("Programming", course.getCourseName());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectCredits_when_courseCreated() {
        assertEquals(3, course.getCredits());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectTeacherName_when_courseCreated() {
        assertEquals("Dr. Ahmed", course.getTeacherName());
    }

    @Test
    @Tag("fast")
    void should_updateTeacherName_when_setTeacherNameCalled() {
        course.setTeacherName("Dr. Sara");
        assertEquals("Dr. Sara", course.getTeacherName());
    }

    // --- NEGATIVE TESTS ---

    @Test
    @Tag("fast")
    void should_notMatchWrongCourseId_when_differentIdChecked() {
        assertNotEquals("CS999", course.getCourseId());
    }

    @Test
    @Tag("fast")
    void should_notMatchWrongCredits_when_differentValueChecked() {
        assertNotEquals(99, course.getCredits());
    }

    // --- BOUNDARY TESTS ---

    @Test
    @Tag("fast")
    void should_storeCredits_when_creditIsOne() {
        Course c = new Course("CS001", "Test", 1, "Teacher");
        assertEquals(1, c.getCredits());
    }

    @Test
    @Tag("fast")
    void should_storeCredits_when_creditIsLargeNumber() {
        Course c = new Course("CS002", "Test", 100, "Teacher");
        assertEquals(100, c.getCredits());
    }

    // --- EXCEPTION / NULL TESTS ---

    @Test
    @Tag("fast")
    void should_allowNullTeacher_when_nullPassedToSetTeacherName() {
        course.setTeacherName(null);
        assertNull(course.getTeacherName());
    }

    @Test
    @Tag("fast")
    void should_allowNullCourseName_when_nullPassedToConstructor() {
        Course c = new Course("CS003", null, 3, "Teacher");
        assertNull(c.getCourseName());
    }
}