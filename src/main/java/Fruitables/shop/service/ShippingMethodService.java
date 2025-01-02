package Fruitables.shop.service;

import Fruitables.shop.dto.ShippingMethodDTO;
import Fruitables.shop.entity.ShippingMethod;
import Fruitables.shop.repository.ShippingMethodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingMethodService {
    private final ShippingMethodRepository shipRepo;
    public ShippingMethodService(ShippingMethodRepository shipRepo)
    {
        this.shipRepo = shipRepo;
    }

    public List<ShippingMethodDTO> getAllShippingMethod() {
        List<ShippingMethodDTO> shiplist = new ArrayList<>();
        for (ShippingMethod s : this.shipRepo.findAll())
        {
            shiplist.add(new ShippingMethodDTO(s));
        }
        return shiplist;
    }
}
