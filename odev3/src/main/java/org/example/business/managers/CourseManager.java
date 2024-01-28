package org.example.business.managers;

import org.example.business.services.CourseService;
import org.example.dataAccess.dao.CourseDao;
import org.example.entity.Course;

import java.util.List;

public class CourseManager implements CourseService {

    private CourseDao courseDao;

    public CourseManager(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course getByName(String name) {
        return courseDao.getByName(name);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }


    @Override
    public boolean add(Course course) {
        if (courseDao.getByName(course.getCourseName()) != null) {
            System.out.println("Kurs ismi mevcut!");
            return false;
        }
        courseDao.add(course);
        return true;
    }

    @Override
    public boolean delete(String name) {
        Course course = getByName(name);
        if (course == null) {
            System.out.println("Kurs bulunamadı!");
            return false;
        }
        courseDao.delete(course);
        return true;
    }
}