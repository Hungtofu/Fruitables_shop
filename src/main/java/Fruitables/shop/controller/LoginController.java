package Fruitables.shop.controller;


import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.SignInRequest;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.UserService;
import Fruitables.shop.util.ApiMessage;
import Fruitables.shop.util.SecurityUtil;
import Fruitables.shop.util.error.IdInvalidException;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Value("${jwt.refresh-token-validity-in-seconds}")
    private Long jwtRefreshExpiration;

    private final UserService userService;
    private final SecurityUtil securityUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public LoginController(SecurityUtil securityUtil, UserService userService, SecurityUtil securityUtil1, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.securityUtil = securityUtil1;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


    @PostMapping("/signup")
    public ResponseEntity<UserLoginDTO.UserInfo> signUp(@RequestBody SignUpRequest signUpRequest){
        User newUser = userService.addUser(signUpRequest);
        if(newUser == null){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        UserLoginDTO.UserInfo userInfo = new UserLoginDTO.UserInfo();
        userInfo.setEmail(newUser.getEmail());
        userInfo.setUserName(newUser.getUserName());
        userInfo.setId(newUser.getId());

        return ResponseEntity.status(HttpStatus.OK.value()).body(userInfo);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserLoginDTO> signIn(@Valid @RequestBody SignInRequest signInRequest){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);


        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserLoginDTO userLoginDTO = new UserLoginDTO();
        User user = userService.findByEmail(signInRequest.getEmail());
        UserLoginDTO.UserInfo currentUserDTO = new UserLoginDTO.UserInfo(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getImg()
        );

        String accessToken = this.securityUtil.createAccessToken(signInRequest.getEmail(), currentUserDTO);

        userLoginDTO.setAccessToken(accessToken);
        userLoginDTO.setUser(currentUserDTO);

        String refreshToken = this.securityUtil.createRefreshToken(signInRequest.getEmail(), userLoginDTO);
        this.userService.updateUserToken(refreshToken, signInRequest.getEmail());

        ResponseCookie responseCookie = ResponseCookie.from("refresh_token", refreshToken)
                .httpOnly(true)
                .secure(false)
                .sameSite("None")
                .path("/")
                .maxAge(jwtRefreshExpiration)
                .build();

        return ResponseEntity.status(HttpStatus.OK.value())
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(userLoginDTO);
    }

    @GetMapping("/refresh")
    @ApiMessage("Get user by refresh token")
    public ResponseEntity<UserLoginDTO> getRefreshToken(@CookieValue(name = "refresh_token") String refreshToken) throws IdInvalidException {

        Jwt decodedToken = this.securityUtil.checkValidRefreshToken(refreshToken);
        String email = decodedToken.getSubject();

        User currentUser = this.userService.getUserByRefreshTokenAnfEmail(refreshToken, email);
        if(currentUser == null){
            throw new IdInvalidException("refresh token invalid");
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO();

        UserLoginDTO.UserInfo currentUserDTO = new UserLoginDTO.UserInfo(
                currentUser.getId(),
                currentUser.getUserName(),
                currentUser.getEmail(),
                currentUser.getImg()
        );

        String accessToken = this.securityUtil.createAccessToken(email, currentUserDTO);

        userLoginDTO.setAccessToken(accessToken);
        userLoginDTO.setUser(currentUserDTO);

        String newRefreshToken = this.securityUtil.createRefreshToken(email, userLoginDTO);
        this.userService.updateUserToken(newRefreshToken, email);

        ResponseCookie responseCookie = ResponseCookie.from("refresh_token", newRefreshToken)
                .httpOnly(true)
                .secure(false)
                .sameSite("None")
                .path("/")
                .maxAge(jwtRefreshExpiration)
                .build();

        return ResponseEntity.status(HttpStatus.OK.value())
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(userLoginDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() throws IdInvalidException{

        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            throw new IdInvalidException("Invalid access token");
        }

        this.userService.updateUserToken(null, email);
        ResponseCookie deleteCookie = ResponseCookie
                .from("refresh_token", null)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .build();
        return ResponseEntity.status(HttpStatus.OK.value())
                .header(HttpHeaders.SET_COOKIE, deleteCookie.toString())
                .body(null);
    }


}
