package org.example.entity;

public class Instructor {

    private String instructorName;
    private String instructorLastName;
    private String email;
    private int age;

    public Instructor(String instructorName, String instructorLastName, String email, int age) {
        this.instructorName = instructorName;
        this.instructorLastName = instructorLastName;
        this.email = email;
        this.age = age;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
