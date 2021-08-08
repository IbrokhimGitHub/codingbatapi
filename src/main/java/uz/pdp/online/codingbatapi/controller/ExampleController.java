package uz.pdp.online.codingbatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.codingbatapi.entity.Example;
import uz.pdp.online.codingbatapi.payload.ExampleDto;
import uz.pdp.online.codingbatapi.payload.ExampleResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.service.ExampleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/example")
public class ExampleController {
    @Autowired
    ExampleService exampleService;
    @GetMapping
    public ResponseEntity<?> getAllByPage(){
        List<Example> all = exampleService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        ExampleResult one = exampleService.getOne(id);
        return ResponseEntity.status(one.isSuccess()?200:409).body(one);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id){
        Result delete = exampleService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:404).body(delete);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ExampleDto exampleDto){
        Result add = exampleService.add(exampleDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid@PathVariable Integer id,@RequestBody ExampleDto exampleDto){
        Result edit = exampleService.edit(id, exampleDto);
        return ResponseEntity.status(edit.isSuccess()?202:404).body(edit);
    }





}

