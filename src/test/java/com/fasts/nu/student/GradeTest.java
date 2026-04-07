package com.fasts.nu.student;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GradeTest {

    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        student = new Student("S001", "Ali", "ali@nu.edu.pk", 20);
        course = new Course("CS101", "Programming", 3, "Dr. Ahmed");
    }

    // --- POSITIVE TESTS ---

    @Test
    @Tag("slow")
    @Order(1)
    void should_returnGradeA_when_marksAre95() {
        Grade grade = new Grade(student, course, 95);
        assertEquals("A", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(2)
    void should_returnGradeB_when_marksAre85() {
        Grade grade = new Grade(student, course, 85);
        assertEquals("B", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(3)
    void should_returnGradeC_when_marksAre75() {
        Grade grade = new Grade(student, course, 75);
        assertEquals("C", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(4)
    void should_returnGradeD_when_marksAre65() {
        Grade grade = new Grade(student, course, 65);
        assertEquals("D", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(5)
    void should_returnGradeF_when_marksAre50() {
        Grade grade = new Grade(student, course, 50);
        assertEquals("F", grade.getGradeLetter());
    }

    // --- BOUNDARY TESTS ---

    @Test
    @Tag("slow")
    @Order(6)
    void should_returnGradeA_when_marksAreExactly90() {
        Grade grade = new Grade(student, course, 90);
        assertEquals("A", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(7)
    void should_returnGradeB_when_marksAreExactly80() {
        Grade grade = new Grade(student, course, 80);
        assertEquals("B", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(8)
    void should_returnGradeF_when_marksAreZero() {
        Grade grade = new Grade(student, course, 0);
        assertEquals("F", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(9)
    void should_returnGradeA_when_marksAre100() {
        Grade grade = new Grade(student, course, 100);
        assertEquals("A", grade.getGradeLetter());
    }

    // --- NEGATIVE TESTS ---

    @Test
    @Tag("slow")
    @Order(10)
    void should_notReturnA_when_marksAreBelow90() {
        Grade grade = new Grade(student, course, 89);
        assertNotEquals("A", grade.getGradeLetter());
    }

    // --- setMarks UPDATE TEST ---

    @Test
    @Tag("slow")
    @Order(11)
    void should_updateGradeToA_when_marksUpdatedTo95() {
        Grade grade = new Grade(student, course, 50);
        grade.setMarks(95);
        assertEquals("A", grade.getGradeLetter());
    }

    @Test
    @Tag("slow")
    @Order(12)
    void should_updateGradeToF_when_marksUpdatedTo30() {
        Grade grade = new Grade(student, course, 95);
        grade.setMarks(30);
        assertEquals("F", grade.getGradeLetter());
    }
}