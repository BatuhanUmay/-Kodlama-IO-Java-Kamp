package org.example.entity;

public class Course {

    private String courseName;
    private int price;

    private Instructor instructor;
    private Category category;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Course(String courseName, int price, Instructor instructor, Category category) {
        this.courseName = courseName;
        this.price = price;
        this.instructor = instructor;
        this.category = category;
    }
}
