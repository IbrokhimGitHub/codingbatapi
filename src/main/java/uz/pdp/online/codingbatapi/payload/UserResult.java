package uz.pdp.online.codingbatapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.online.codingbatapi.entity.Category;
import uz.pdp.online.codingbatapi.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResult {
    private User user;
    private boolean success;
}
