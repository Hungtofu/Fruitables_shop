package Fruitables.shop.controller;


import Fruitables.shop.payload.Request.SignInRequest;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.payload.ResponseData;
import Fruitables.shop.service.LoginService;
import Fruitables.shop.util.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SecurityUtil securityUtil;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public LoginController(SecurityUtil securityUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){

        ResponseData responseData = new ResponseData();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest signInRequest){

        ResponseData responseData = new ResponseData();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        responseData.setData(this.securityUtil.createToken(authentication));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
