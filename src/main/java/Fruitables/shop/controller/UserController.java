package Fruitables.shop.controller;

import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.UserService;
import Fruitables.shop.util.ApiMessage;
import Fruitables.shop.util.SecurityUtil;
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
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(userService.getAll());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/account")
    @ApiMessage("fetch account")
    public ResponseEntity<UserLoginDTO.UserInfo> getAccount(){
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get(): "";
        User currentUser = userService.findByEmail(email);

        UserLoginDTO.UserInfo userInfo = new UserLoginDTO.UserInfo();
        if (currentUser != null){
            userInfo.setId(currentUser.getId());
            userInfo.setUserName(currentUser.getUserName());
            userInfo.setEmail(currentUser.getEmail());
        }

        return ResponseEntity.status(HttpStatus.OK.value()).body(userInfo);
    }

}
