package Fruitables.shop.dto;

import Fruitables.shop.entity.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeDTO {
    private int id;
    private String name;
    public PaymentTypeDTO(PaymentType p)
    {
        this.id = p.getId();
        this.name = p.getName();
    }
}
