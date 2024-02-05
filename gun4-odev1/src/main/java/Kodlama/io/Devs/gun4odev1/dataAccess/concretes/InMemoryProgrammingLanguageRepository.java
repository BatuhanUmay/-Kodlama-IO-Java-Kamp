package Kodlama.io.Devs.gun4odev1.dataAccess.concretes;

import Kodlama.io.Devs.gun4odev1.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.gun4odev1.entities.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<>();

        programmingLanguages.add(new ProgrammingLanguage(1, "Python"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(3, "C++"));
        programmingLanguages.add(new ProgrammingLanguage(4, "Javascript"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                return programmingLanguage;
            }
        }
        throw new Exception("Bu id ye sahip bir programlama dili bulunmamaktadır");
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
        ProgrammingLanguage programmingLanguageNew = getById(programmingLanguage.getId());
        programmingLanguageNew.setName(programmingLanguage.getName());
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        ProgrammingLanguage programmingLanguage = getById(id);
        programmingLanguages.remove(programmingLanguage);
    }
}
