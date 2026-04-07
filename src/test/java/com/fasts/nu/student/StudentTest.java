package com.fasts.nu.student;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("S001", "Ali Khan", "ali@nu.edu.pk", 20);
    }

    // --- POSITIVE TESTS ---

    @Test
    @Tag("fast")
    void should_returnCorrectId_when_studentCreated() {
        assertEquals("S001", student.getStudentId());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectName_when_studentCreated() {
        assertEquals("Ali Khan", student.getName());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectEmail_when_studentCreated() {
        assertEquals("ali@nu.edu.pk", student.getEmail());
    }

    @Test
    @Tag("fast")
    void should_returnCorrectAge_when_studentCreated() {
        assertEquals(20, student.getAge());
    }

    @Test
    @Tag("fast")
    void should_updateName_when_setNameCalled() {
        student.setName("Sara Ahmed");
        assertEquals("Sara Ahmed", student.getName());
    }

    @Test
    @Tag("fast")
    void should_updateEmail_when_setEmailCalled() {
        student.setEmail("sara@nu.edu.pk");
        assertEquals("sara@nu.edu.pk", student.getEmail());
    }

    // --- NEGATIVE TESTS ---

    @Test
    @Tag("fast")
    void should_notMatchWrongName_when_differentNameProvided() {
        assertNotEquals("Wrong Name", student.getName());
    }

    @Test
    @Tag("fast")
    void should_notMatchWrongEmail_when_differentEmailProvided() {
        assertNotEquals("wrong@email.com", student.getEmail());
    }

    // --- BOUNDARY TESTS ---

    @Test
    @Tag("fast")
    void should_storeAge_when_ageIsMinimumValue() {
        Student s = new Student("S002", "Young", "y@nu.edu.pk", 1);
        assertEquals(1, s.getAge());
    }

    @Test
    @Tag("fast")
    void should_storeAge_when_ageIsLargeValue() {
        Student s = new Student("S003", "Old", "o@nu.edu.pk", 100);
        assertEquals(100, s.getAge());
    }

    // --- EXCEPTION / NULL TESTS ---

    @Test
    @Tag("fast")
    void should_allowNullName_when_nullPassedToSetName() {
        student.setName(null);
        assertNull(student.getName());
    }

    @Test
    @Tag("fast")
    void should_allowNullEmail_when_nullPassedToSetEmail() {
        student.setEmail(null);
        assertNull(student.getEmail());
    }
}