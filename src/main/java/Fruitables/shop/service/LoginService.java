package Fruitables.shop.service;

import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean addUser(SignUpRequest signUpRequest) {
        User user = userRepository.findByEmail(signUpRequest.getEmail());
        if(user == null){
            try {
                User newUser = new User(signUpRequest.getEmail(),
                        passwordEncoder.encode(signUpRequest.getPassword()),
                        signUpRequest.getUserName());
                userRepository.save(newUser);
                return true;
            } catch (Exception e){
                System.out.println("Error add user: + " + e.getMessage());
                return false;
            }
        }
        return false;

    }

}
