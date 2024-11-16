package Fruitables.shop.controller;


import Fruitables.shop.payload.Request.SignInRequest;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.payload.ResponseData;
import Fruitables.shop.service.serviceIMP.LoginServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceIMP loginService;


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){

        ResponseData responseData = new ResponseData();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){

        ResponseData responseData = new ResponseData();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
