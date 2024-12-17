package Fruitables.shop.dto;

import Fruitables.shop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInformationDTO {
    private int id;
    private User user;
    private String firstName;
    private String lastName;
    private String phoneNumbers;
    private String address1;
    private String address2;
    private String commune;
    private String district;
    private String province;
}
