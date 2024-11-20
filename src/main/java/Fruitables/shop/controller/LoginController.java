package Fruitables.shop.controller;


import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.SignInRequest;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.UserService;
import Fruitables.shop.util.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final SecurityUtil securityUtil;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public LoginController(SecurityUtil securityUtil, UserService userService, SecurityUtil securityUtil1, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.securityUtil = securityUtil1;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


    @PostMapping("/signup")
    public ResponseEntity<RestResponse<Object>> signUp(@RequestBody SignUpRequest signUpRequest){

        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(userService.addUser(signUpRequest));
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<RestResponse<Object>> signIn(@Valid @RequestBody SignInRequest signInRequest){

        RestResponse<Object> response = new RestResponse<Object>();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String token = this.securityUtil.createAccessToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserLoginDTO userLoginDTO = new UserLoginDTO();

        User user = userService.findByEmail(signInRequest.getEmail());
        UserLoginDTO.UserInfo currentUserDTO = new UserLoginDTO.UserInfo(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );

        userLoginDTO.setAccessToken(token);
        userLoginDTO.setUser(currentUserDTO);

        response.setData(userLoginDTO);

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }


}
