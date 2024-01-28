package org.example.dataAccess.dao;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorDao {

    void add(Instructor instructor);

    void delete(Instructor instructor);

    List<Instructor> getAll();

    Instructor getByName(String name);
}
