package org.example.business.managers;

import org.example.business.services.InstructorService;
import org.example.dataAccess.dao.InstructorDao;
import org.example.entity.Instructor;

import java.util.List;

public class InstructorManager implements InstructorService {

    private InstructorDao instructorDao;

    public InstructorManager(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public Instructor getByName(String name) {
        return instructorDao.getByName(name);
    }

    @Override
    public List<Instructor> getAll() {
        return instructorDao.getAll();
    }


    @Override
    public boolean add(Instructor instructor) {
        if (instructorDao.getByName(instructor.getInstructorName()) != null) {
            System.out.println("Eğitmen ismi mevcut!");
            return false;
        }
        instructorDao.add(instructor);
        return true;
    }

    @Override
    public boolean delete(String name) {
        Instructor instructor = getByName(name);
        if (instructor == null) {
            System.out.println("Eğitmen bulunamadı!");
            return false;
        }
        instructorDao.delete(instructor);
        return true;
    }
}