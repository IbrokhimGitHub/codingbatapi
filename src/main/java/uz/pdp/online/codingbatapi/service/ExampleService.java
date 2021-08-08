package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Example;
import uz.pdp.online.codingbatapi.entity.Task;
import uz.pdp.online.codingbatapi.payload.ExampleDto;
import uz.pdp.online.codingbatapi.payload.ExampleResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.payload.TaskResult;
import uz.pdp.online.codingbatapi.repository.ExampleRepository;
import uz.pdp.online.codingbatapi.repository.TaskRepository;

import javax.swing.text.EditorKit;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {
    @Autowired
    ExampleRepository exampleRepository;
    @Autowired
    TaskRepository taskRepository;
    public ExampleResult getOne(Integer id){
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (!optionalExample.isPresent()) {
            return new ExampleResult(new Example(),false);
        }
        return new ExampleResult(optionalExample.get(),true);
    }
    public List<Example> getAll(){
        List<Example> all = exampleRepository.findAll();
        return all;
    }
    public Result delete(Integer id){
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (!optionalExample.isPresent()) {
            return new Result("cant find such example",false);
        }
        exampleRepository.deleteById(id);
        return new Result("example with id = "+id+" deleted",true);
    }
    public Result add(ExampleDto exampleDto){
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (!optionalTask.isPresent()) {
            return new Result("cant find such example",false);
        }
        Example example=new Example();
        example.setIncoming(exampleDto.getIncoming());
        example.setOutgoing(exampleDto.getOutgoing());
        example.setTask(optionalTask.get());
        exampleRepository.save(example);
        return new Result("new example saved successfully",true);

    }
    public Result edit(Integer id, ExampleDto exampleDto){
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (!optionalExample.isPresent()) {
            return new Result("cant find such example",false);
        }
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (!optionalTask.isPresent()) {
            return new Result("cant find such example",false);
        }
        Example example = optionalExample.get();
        example.setIncoming(exampleDto.getIncoming());
        example.setOutgoing(exampleDto.getOutgoing());
        example.setTask(optionalTask.get());
        exampleRepository.save(example);
        return new Result(" example edited successfully",true);

    }
}

