package Fruitables.shop.payload.Request;

import Fruitables.shop.util.constant.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

@Getter
@Setter
public class UpdateUserRequest {

    private String userName;
    private GenderEnum gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String dob;

}
