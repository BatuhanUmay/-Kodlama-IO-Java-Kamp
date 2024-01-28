package org.example.dataAccess.dao;

import org.example.entity.Course;

import java.util.List;

public interface CourseDao {

    void add(Course course);

    void delete(Course course);

    List<Course> getAll();

    Course getByName(String name);
}
