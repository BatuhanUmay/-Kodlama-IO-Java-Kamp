package Kodlama.io.Devs.gun4odev1.webApi.controllers;

import Kodlama.io.Devs.gun4odev1.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.gun4odev1.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getAll")
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ProgrammingLanguage getById(@PathVariable int id) throws Exception {
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.add(programmingLanguage);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage, @PathVariable int id) throws Exception {
        programmingLanguageService.update(programmingLanguage, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }

}
