package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.entity.Task;
import uz.pdp.online.codingbatapi.payload.AnswerDto;
import uz.pdp.online.codingbatapi.payload.AnswerResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.repository.AnswerRepository;
import uz.pdp.online.codingbatapi.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TaskRepository taskRepository;
    public AnswerResult getOne(Integer id){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (!optionalAnswer.isPresent()) {
            return new AnswerResult(new Answer(),false);
        }
        return new AnswerResult(optionalAnswer.get(),true);
    }
    public List<Answer> getAll(){
        List<Answer> all = answerRepository.findAll();
        return all;
    }
    public Result delete(Integer id){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (!optionalAnswer.isPresent()) {
            return new Result("cant find such answer",false);
        }
        answerRepository.deleteById(id);
        return new Result("answer with id = "+id+" deleted",true);
    }
    public Result add(AnswerDto answerDto){
//        taskRepository.findAllById(answerDto.getTasksId());
//        if (!optionalTask.isPresent()) {
//            return new Result("cant find such task",false);
//        }
        Answer answer=new Answer();
        answer.setTasks( taskRepository.findAllById(answerDto.getTasksId()));
        answer.setCorrect(answerDto.isCorrect());
        answer.setText(answerDto.getText());
        answerRepository.save(answer);
        return new Result("new answer saved",true);

    }
    public Result edit(Integer id,AnswerDto answerDto){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (!optionalAnswer.isPresent()) {
            return new Result("cant find such answer",false);
        }
//        Optional<Task> optionalTask = taskRepository.findById(answerDto.getTaskId());
//        if (!optionalTask.isPresent()) {
//            return new Result("cant find such task",false);
//        }
        Answer answer = optionalAnswer.get();
//        answer.setTask(optionalTask.get());
        answer.setTasks( taskRepository.findAllById(answerDto.getTasksId()));
        answer.setCorrect(answerDto.isCorrect());
        answer.setText(answerDto.getText());
        answerRepository.save(answer);
        return new Result(" answer is edited",true);

    }
}
