package Kodlama.io.Devs.gun4odev1.business.concretes;

import Kodlama.io.Devs.gun4odev1.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.gun4odev1.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.gun4odev1.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        if (programmingLanguage.getName().isEmpty()) {
            throw new Exception("Progralama dili ismi boş olamaz");
        }

        for (ProgrammingLanguage language : getAll()) {
            if (language.getId() == programmingLanguage.getId()) {
                throw new Exception("Aynı id ye sahip bir bilgi bulunmaktadır");
            }
        }
        programmingLanguageRepository.add(programmingLanguage);
    }


    @Override
    public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
        if (programmingLanguageRepository.getById(id) == null) {
            throw new Exception("Programlama dili veri tabanında yok");
        }
        programmingLanguageRepository.update(programmingLanguage, id);
    }


    @Override
    public void delete(int id) throws Exception {
        programmingLanguageRepository.delete(id);
    }
}
