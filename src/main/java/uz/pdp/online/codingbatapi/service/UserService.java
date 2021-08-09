package uz.pdp.online.codingbatapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.entity.User;
import uz.pdp.online.codingbatapi.entity.Task;
import uz.pdp.online.codingbatapi.payload.AnswerResult;
import uz.pdp.online.codingbatapi.payload.UserDto;
import uz.pdp.online.codingbatapi.payload.UserResult;
import uz.pdp.online.codingbatapi.payload.Result;
import uz.pdp.online.codingbatapi.repository.AnswerRepository;
import uz.pdp.online.codingbatapi.repository.UserRepository;
import uz.pdp.online.codingbatapi.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AnswerRepository answerRepository;

    public UserResult getOne(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new UserResult(new User(), false);
        }
        return new UserResult(optionalUser.get(), true);
    }

    public List<User> getAll() {
        List<User> all = userRepository.findAll();
        return all;
    }

    public Result delete(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new Result("cant find such user", false);
        }
        userRepository.deleteById(id);
        return new Result("user with id = " + id + " deleted", true);
    }
    public Result add(UserDto userDto){
        List<Answer> answerList = answerRepository.findAllById(userDto.getAnswersId());
        User user=new User();
        user.setAnswers(answerList);
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new Result("user saved",true);
    }
    public Result edit(Integer id,UserDto userDto){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new Result("cant find user",false);
        }
        List<Answer> answerList = answerRepository.findAllById(userDto.getAnswersId());
        User user = optionalUser.get();
        user.setAnswers(answerList);
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new Result("user edited",true);

    }

}