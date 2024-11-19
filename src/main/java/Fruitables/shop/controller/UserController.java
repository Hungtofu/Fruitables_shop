package Fruitables.shop.controller;

import Fruitables.shop.payload.ResponseData;
import Fruitables.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllUser(){

        ResponseData responseData = new ResponseData();
        responseData.setData(userService.getAll());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
