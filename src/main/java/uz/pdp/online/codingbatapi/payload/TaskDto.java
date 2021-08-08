package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;
    private boolean hasStar;
    private boolean isDone;
    private Integer categoryId;
}
