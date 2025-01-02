package Fruitables.shop.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddDeliveryInformationRequest {

    private String firstName;
    private String lastName;
    private String phoneNumbers;
    private String address1;
    private String address2;
    private String commune;
    private String district;
    private String province;

}
