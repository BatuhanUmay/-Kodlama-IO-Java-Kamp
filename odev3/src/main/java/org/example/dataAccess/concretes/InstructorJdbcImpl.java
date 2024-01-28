package org.example.dataAccess.concretes;

import org.example.dataAccess.dao.InstructorDao;
import org.example.dataAccess.db.Database;
import org.example.entity.Instructor;

import java.util.List;

public class InstructorJdbcImpl implements InstructorDao {

    private final Database database = new Database();

    @Override
    public void add(Instructor instructor) {
        database.instructors.add(instructor);
        System.out.println("Instructor added with JDBC:" + instructor.getInstructorName());
    }

    @Override
    public void delete(Instructor instructor) {
        try {
            database.instructors.remove(instructor);
            System.out.println("Instructor deleted with JDBC:" + instructor.getInstructorName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Instructor> getAll() {
        return database.instructors;
    }

    @Override
    public Instructor getByName(String name) {
        return database.instructors.stream().filter(instructor -> instructor.getInstructorName().equals(name)).findFirst().orElse(null);
    }
}
