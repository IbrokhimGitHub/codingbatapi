package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private String text;
    private boolean isCorrect;
    private Integer taskId;
    private Integer userId;

}
