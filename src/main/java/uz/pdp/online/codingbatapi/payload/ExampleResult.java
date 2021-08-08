package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Category;
import uz.pdp.online.codingbatapi.entity.Example;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExampleResult {
    private Example example;
    private boolean success;
}
