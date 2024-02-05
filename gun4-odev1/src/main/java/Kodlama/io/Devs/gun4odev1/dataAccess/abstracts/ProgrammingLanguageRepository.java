package Kodlama.io.Devs.gun4odev1.dataAccess.abstracts;

import Kodlama.io.Devs.gun4odev1.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id) throws Exception;

    void add(ProgrammingLanguage programmingLanguage) throws Exception;
    void update(ProgrammingLanguage programmingLanguage, int id) throws Exception;

    void delete(int id) throws Exception;


}
