package Fruitables.shop.controller;

import Fruitables.shop.dto.UserInfoDetail;
import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.UpdateUserRequest;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.UserService;
import Fruitables.shop.util.ApiMessage;
import Fruitables.shop.util.ImgUtil;
import Fruitables.shop.util.SecurityUtil;
import Fruitables.shop.util.constant.GenderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImgUtil imgUtil;

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
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }

        User currentUser = userService.findByEmail(email);

        UserLoginDTO.UserInfo userInfo = new UserLoginDTO.UserInfo();
        if (currentUser != null){
            userInfo.setId(currentUser.getId());
            userInfo.setUserName(currentUser.getUserName());
            userInfo.setEmail(currentUser.getEmail());
            userInfo.setImg(currentUser.getImg());
        }

        return ResponseEntity.status(HttpStatus.OK.value()).body(userInfo);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateUser(@RequestPart(name = "userUpdate") UpdateUserRequest updateUserRequest,
                                              @RequestPart(name = "file") MultipartFile file) throws IOException {
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }

        String imgUrl = imgUtil.saveUserImage(email, file);
        boolean success = this.userService.updateUserInfo(updateUserRequest, email, imgUrl);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

}
