package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Language;
import uz.pdp.online.codingbatapi.payload.LanguageResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;
    public LanguageResult getOne(Integer id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent()) {
            return new LanguageResult(new Language(),false);
        }
        return new LanguageResult(optionalLanguage.get(),true);
    }
    public List<Language> getAll(){
        List<Language> all = languageRepository.findAll();
        return all;
    }
    public Result delete(Integer id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent()) {
            return new Result("cant find such language",false);
        }
        languageRepository.deleteById(id);
        return new Result("language with id = "+id+" deleted",true);
    }
    public Result add(Language language){
        boolean existsByName = languageRepository.existsByName(language.getName());
        if (!existsByName){
            return new Result("such language already exist",false);
        }
        languageRepository.save(language);
        return new Result("new language added",true);
    }
    public Result edit(Integer id,Language language){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (!optionalLanguage.isPresent()) {
            return new Result("cant fund such language",false);
        }
        Language language1 = optionalLanguage.get();
        language1.setName(language.getName());
        languageRepository.save(language1);
        return new Result("language edited",true);
    }
}

