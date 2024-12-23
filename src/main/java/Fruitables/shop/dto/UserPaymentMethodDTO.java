package Fruitables.shop.dto;

import Fruitables.shop.entity.PaymentType;
import Fruitables.shop.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentMethodDTO {
    private int id;
    private User user;
    private PaymentType paymentType;
    private String provider;
    private String accountNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Timestamp expiryDate;
    private boolean isDefault;
}
