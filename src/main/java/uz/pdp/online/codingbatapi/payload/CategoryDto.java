package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private String name;
    private Integer numberOfStars;
    private String description;
    private Integer languageId;
}
