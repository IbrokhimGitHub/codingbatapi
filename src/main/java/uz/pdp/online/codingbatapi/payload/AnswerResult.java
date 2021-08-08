package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Answer;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerResult {
    private Answer answer;
    private boolean success;
}
