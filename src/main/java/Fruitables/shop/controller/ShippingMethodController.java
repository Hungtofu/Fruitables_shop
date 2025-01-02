package Fruitables.shop.controller;

import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.ShippingMethodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/shipping_method")
public class ShippingMethodController {
    private final ShippingMethodService shippingMethodService;
    public ShippingMethodController(ShippingMethodService shippingMethodService)
    {
        this.shippingMethodService = shippingMethodService;
    }

    @GetMapping("getall")
    public ResponseEntity<RestResponse<Object>> getAll()
    {
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(shippingMethodService.getAllShippingMethod());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }
}
