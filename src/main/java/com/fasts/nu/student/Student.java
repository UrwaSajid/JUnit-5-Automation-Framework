package com.fasts.nu.student;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private int age;

    // Constructor
    public Student(String studentId, String name, String email, int age) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}