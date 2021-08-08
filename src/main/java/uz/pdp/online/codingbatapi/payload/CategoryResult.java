package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Answer;
import uz.pdp.online.codingbatapi.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResult {
    private Category category;
    private boolean success;
}
