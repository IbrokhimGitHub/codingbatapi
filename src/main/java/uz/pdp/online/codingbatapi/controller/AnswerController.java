package uz.pdp.online.codingbatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.payload.AnswerDto;
import uz.pdp.online.codingbatapi.payload.AnswerResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.service.AnswerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;
    @GetMapping
    public ResponseEntity<?> getAllByPage(){
        List<Answer> all = answerService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        AnswerResult one = answerService.getOne(id);
        return ResponseEntity.status(one.isSuccess()?200:409).body(one);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id){
        Result delete = answerService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:404).body(delete);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AnswerDto answerDto){
        Result add = answerService.add(answerDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid@PathVariable Integer id,@RequestBody AnswerDto answerDto){
        Result edit = answerService.edit(id, answerDto);
        return ResponseEntity.status(edit.isSuccess()?202:404).body(edit);
    }





}

