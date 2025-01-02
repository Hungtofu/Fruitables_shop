package Fruitables.shop.controller;

import Fruitables.shop.dto.UserPaymentMethodDTO;
import Fruitables.shop.payload.Request.UserPaymentMethodRequest;
import Fruitables.shop.service.UserPaymentMethodService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_payment_method")
public class UserPaymentMethodController {
    private final UserPaymentMethodService userPaymentService;

    public UserPaymentMethodController (UserPaymentMethodService userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @GetMapping("/add_user_payment")
    public ResponseEntity<Boolean> addUserPaymentMethod(@RequestBody UserPaymentMethodRequest request)
    {
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        boolean isSuccess = false;
        if(!email.isEmpty()){
            isSuccess = userPaymentService.addPaymentMethod(email, request);
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body(isSuccess);
    }
}
