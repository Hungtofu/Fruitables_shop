package Fruitables.shop.controller;

import Fruitables.shop.dto.DeliveryInformationDTO;
import Fruitables.shop.service.DeliveryInformationService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery_info")
public class DeliveryInformationController {
    private final DeliveryInformationService deliveryService;
    public DeliveryInformationController(DeliveryInformationService deliveryService)
    {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/item")
    public ResponseEntity<DeliveryInformationDTO> addDeliveryInfo(@RequestBody DeliveryInformationDTO delivery)
    {
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(null);
        }
        deliveryService.saveUserDeliveryInfo(email, delivery);
        return ResponseEntity.ok(delivery);
    }
}
