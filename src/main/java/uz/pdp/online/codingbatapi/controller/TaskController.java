package uz.pdp.online.codingbatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.codingbatapi.entity.Task;
import uz.pdp.online.codingbatapi.payload.TaskDto;
import uz.pdp.online.codingbatapi.payload.TaskResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping
    public ResponseEntity<?> getAllByPage(){
        List<Task> all = taskService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        TaskResult one = taskService.getOne(id);
        return ResponseEntity.status(one.isSuccess()?200:409).body(one);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id){
        Result delete = taskService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:404).body(delete);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody TaskDto taskDto){
        Result add = taskService.add(taskDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid@PathVariable Integer id,@RequestBody TaskDto taskDto){
        Result edit = taskService.edit(id, taskDto);
        return ResponseEntity.status(edit.isSuccess()?202:404).body(edit);
    }





}

