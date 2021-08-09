package uz.pdp.online.codingbatapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.codingbatapi.entity.User;
import uz.pdp.online.codingbatapi.payload.UserDto;
import uz.pdp.online.codingbatapi.payload.UserResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<?> getAllByPage(){
        List<User> all = userService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        UserResult one = userService.getOne(id);
        return ResponseEntity.status(one.isSuccess()?200:409).body(one);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id){
        Result delete = userService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:404).body(delete);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody UserDto userDto){
        Result add = userService.add(userDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid@PathVariable Integer id,@RequestBody UserDto userDto){
        Result edit = userService.edit(id, userDto);
        return ResponseEntity.status(edit.isSuccess()?202:404).body(edit);
    }





}

