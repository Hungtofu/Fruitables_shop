package Fruitables.shop.controller;

import Fruitables.shop.dto.DeliveryInformationDTO;
import Fruitables.shop.service.DeliveryInformationService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery_info")
public class DeliveryInformationController {
    private final DeliveryInformationService deliveryService;
    public DeliveryInformationController(DeliveryInformationService deliveryService)
    {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/item")
    public ResponseEntity<Boolean> addDelivery(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumbers, @RequestParam String address1, @RequestParam String address2, @RequestParam String commune, @RequestParam String district, @RequestParam String province)
    {
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK.value())
                    .body(null);
        }
        // deliveryService.saveUserDeliveryInfo(email, delivery);
        boolean success = deliveryService.addDeliveryInfo(email, firstName, lastName, phoneNumbers, address1, address2, commune, district, province);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

    @PostMapping("/items")
    public ResponseEntity<?> getDeliveryByUser() {
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK.value())
                    .body(null);
        }
        List<DeliveryInformationDTO> list = deliveryService.getDeliveryInformationByUser(email);
        return ResponseEntity.status(HttpStatus.OK.value()).body(list);
    }
}
