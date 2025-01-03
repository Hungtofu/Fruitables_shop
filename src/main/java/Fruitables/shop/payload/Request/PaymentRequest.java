package Fruitables.shop.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private int userPaymentMethodId;
    private int shippingAddressId;
    private int shippingMethodId;
    private int orderStatusId = 4;

}
