package org.example.dataAccess.concretes;

import org.example.dataAccess.dao.CourseDao;
import org.example.dataAccess.db.Database;
import org.example.entity.Course;

import java.util.List;

public class CourseHibernateImpl implements CourseDao {

    private final Database database = new Database();

    @Override
    public void add(Course course) {
        database.courses.add(course);
        System.out.println("Course added with Hibernate:" + course.getCourseName());
    }

    @Override
    public void delete(Course course) {
        try {
            database.courses.remove(course);
            System.out.println("Course deleted with Hibernate:" + course.getCourseName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Course> getAll() {
        return database.courses;
    }

    @Override
    public Course getByName(String name) {
        return database.courses.stream().filter(course -> course.getCourseName().equals(name)).findFirst().orElse(null);
    }
}
