package Fruitables.shop.service;

import Fruitables.shop.dto.UserLoginDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.payload.Request.SignUpRequest;
import Fruitables.shop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

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

    public List<UserLoginDTO.UserInfo> getAll(){
        List<User> listUser = userRepository.findAll();
        List<UserLoginDTO.UserInfo> listUserLoginDTO = new ArrayList<>();
        for(User u : listUser){
            listUserLoginDTO.add(new UserLoginDTO.UserInfo(u.getId(),
                    u.getUserName(),
                    u.getEmail()));
        }
        return listUserLoginDTO;
    }

}
