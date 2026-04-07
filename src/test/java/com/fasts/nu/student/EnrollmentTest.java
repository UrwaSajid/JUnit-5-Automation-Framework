package com.fasts.nu.student;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentTest {

    private Student student;
    private Course course;
    private Enrollment enrollment;

    @BeforeEach
    void setUp() {
        student = new Student("S001", "Ali", "ali@nu.edu.pk", 20);
        course = new Course("CS101", "Programming", 3, "Dr. Ahmed");
        enrollment = new Enrollment(student, course);
    }

    // --- POSITIVE TESTS ---

    @Test
    @Tag("integration")
    void should_returnActiveStatus_when_enrollmentCreated() {
        assertEquals("Active", enrollment.getStatus());
    }

    @Test
    @Tag("integration")
    void should_returnCorrectStudent_when_enrollmentCreated() {
        assertEquals(student, enrollment.getStudent());
    }

    @Test
    @Tag("integration")
    void should_returnCorrectCourse_when_enrollmentCreated() {
        assertEquals(course, enrollment.getCourse());
    }

    @Test
    @Tag("integration")
    void should_returnTodayDate_when_enrollmentCreated() {
        assertNotNull(enrollment.getEnrollmentDate());
    }

    @Test
    @Tag("integration")
    void should_updateStatusToCompleted_when_setStatusCalled() {
        enrollment.setStatus("Completed");
        assertEquals("Completed", enrollment.getStatus());
    }

    // --- NEGATIVE TESTS ---

    @Test
    @Tag("integration")
    void should_notBeDropped_when_enrollmentJustCreated() {
        assertNotEquals("Dropped", enrollment.getStatus());
    }

    @Test
    @Tag("integration")
    void should_notBeCompleted_when_enrollmentJustCreated() {
        assertNotEquals("Completed", enrollment.getStatus());
    }

    // --- BOUNDARY TESTS ---

    @Test
    @Tag("integration")
    void should_updateStatusToDropped_when_studentDropsCourse() {
        enrollment.setStatus("Dropped");
        assertEquals("Dropped", enrollment.getStatus());
    }

    // --- EXCEPTION / NULL TESTS ---

    @Test
    @Tag("integration")
    void should_allowNullStatus_when_nullPassedToSetStatus() {
        enrollment.setStatus(null);
        assertNull(enrollment.getStatus());
    }

    @Test
    @Tag("integration")
    void should_createEnrollment_when_studentAndCourseAreValid() {
        assertNotNull(enrollment);
    }
}