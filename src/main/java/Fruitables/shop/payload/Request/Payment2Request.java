package Fruitables.shop.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment2Request {

    private int userPaymentMethodId;
    private int shippingMethodId;
    private int orderStatusId = 4;
    private DeliveryInfomation deliveryInfomation;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeliveryInfomation{
        private String firstName;
        private String lastName;
        private String phoneNumbers;
        private String address1;
        private String address2;
        private String commune;
        private String district;
        private String province;
    }

}
