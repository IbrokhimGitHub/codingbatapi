package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Category;
import uz.pdp.online.codingbatapi.entity.Task;
import uz.pdp.online.codingbatapi.payload.TaskDto;
import uz.pdp.online.codingbatapi.payload.TaskResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.repository.CategoryRepository;
import uz.pdp.online.codingbatapi.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private static Integer starCounter=0;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public TaskResult getOne(Integer id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return new TaskResult(new Task(),false);
        }
        return new TaskResult(optionalTask.get(),true);
    }
    public List<Task> getAll(){
        List<Task> all = taskRepository.findAll();
        return all;
    }
    public Result delete(Integer id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return new Result("cant find such task",false);
        }
        taskRepository.deleteById(id);
        return new Result("task with id = "+id+" deleted",true);
    }
    public Result add(TaskDto taskDto){
        boolean existsByName = taskRepository.existsByName(taskDto.getName());
        if (existsByName) {
            return new Result("such task already exist",false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new Result("cant find such category",false);
        }
        Task task=new Task();
        task.setCategory(optionalCategory.get());
        task.setDone(taskDto.isDone());
        task.setName(taskDto.getName());
        starCounter++;

        task.setHasStar(starCounter % 3 == 0);
        taskRepository.save(task);
        return new Result("new Task is saved",true);

    }
    public Result edit(Integer id,TaskDto taskDto){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return new Result("cant find such task",false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(taskDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new Result("cant find such category",false);
        }
        Task task = optionalTask.get();
        task.setCategory(optionalCategory.get());
        task.setDone(taskDto.isDone());
        task.setName(taskDto.getName());
        taskRepository.save(task);
        return new Result("this task is edited",true);


    }

}

