package uz.pdp.online.codingbatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.codingbatapi.entity.Language;

import uz.pdp.online.codingbatapi.payload.LanguageResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.service.LanguageService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;
    @GetMapping
    public ResponseEntity<?> getAllByPage(){
        List<Language> all = languageService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        LanguageResult one = languageService.getOne(id);
        return ResponseEntity.status(one.isSuccess()?200:409).body(one);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id){
        Result delete = languageService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:404).body(delete);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Language language){
        Result add = languageService.add(language);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid@PathVariable Integer id,@RequestBody Language language){
        Result edit = languageService.edit(id, language);
        return ResponseEntity.status(edit.isSuccess()?202:404).body(edit);
    }





}

