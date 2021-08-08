package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Example;
import uz.pdp.online.codingbatapi.entity.Language;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LanguageResult {
    private Language language;
    private boolean success;
}
