package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Language;
import uz.pdp.online.codingbatapi.entity.Task;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResult {
    private Task task;
    private boolean success;
}
