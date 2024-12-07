package Fruitables.shop.service;

import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.payload.Request.UpdateUserRequest;
import Fruitables.shop.repository.UserRepository;
import Fruitables.shop.util.DateUtil;
import Fruitables.shop.util.ImgUtil;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SecurityUtil securityUtil;
    private final ImgUtil imgUtil;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, SecurityUtil securityUtil, ImgUtil imgUtil) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.securityUtil = securityUtil;
        this.imgUtil = imgUtil;
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);

    }

    public User addUser(SignUpRequest signUpRequest) {
        if(!this.userRepository.existsByEmail(signUpRequest.getEmail())){
            try {
                User newUser = new User(signUpRequest.getEmail(),
                        passwordEncoder.encode(signUpRequest.getPassword()),
                        signUpRequest.getUserName());
                this.userRepository.save(newUser);
                return newUser;
            } catch (Exception e){
                System.out.println("Error add user: + " + e.getMessage());
                return null;
            }
        }
        return null;

    }

    public List<UserLoginDTO.UserInfo> getAll(){
        List<User> listUser = this.userRepository.findAll();
        List<UserLoginDTO.UserInfo> listUserLoginDTO = new ArrayList<>();
        for(User u : listUser){
            listUserLoginDTO.add(new UserLoginDTO.UserInfo(u.getId(),
                    u.getUserName(),
                    u.getEmail(),
                    u.getImg()));
        }
        return listUserLoginDTO;
    }

    public void updateUserToken(String token, String email){
        User currenUser = this.userRepository.findByEmail(email);
        if(currenUser != null){
            currenUser.setRefreshToken(token);
            this.userRepository.save(currenUser);
        }
    }

    public User getUserByRefreshTokenAnfEmail(String token, String email){
        return this.userRepository.findByRefreshTokenAndEmail(token, email);
    }

    public boolean updateUserInfo(UpdateUserRequest updateUserRequest,String email, String imgUrl) throws IOException {
        User currentUser = userRepository.findByEmail(email);
        if(currentUser == null){
            return false;
        }
        currentUser.setUserName(updateUserRequest.getUserName());
        currentUser.setGender(updateUserRequest.getGender());
        Instant dob =DateUtil.parseTimestamp(updateUserRequest.getDob());
        currentUser.setDob(dob);
        currentUser.setImg(imgUrl);
        try {
            this.userRepository.save(currentUser);
            return true;
        }catch (Exception e){
            System.out.println("Error update user: " + e.getMessage());
        }
        return false;

    }

}
