package Fruitables.shop.controller;

import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.PaymentTypeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/payment_type")
public class PaymentTypeController {
    private final PaymentTypeService paymentTypeService;
    public PaymentTypeController(PaymentTypeService paymentTypeService)
    {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllPayment() {
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(paymentTypeService.getAllPaymentType());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }
}
