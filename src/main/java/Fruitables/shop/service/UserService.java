package Fruitables.shop.service;

import Fruitables.shop.dto.UserDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDTO> getAll(){
        List<User> listUser = userRepository.findAll();
        List<UserDTO> listUserDTO = new ArrayList<>();
        for(User u : listUser){
            listUserDTO.add(new UserDTO(u.getId(),
                    u.getUserName(),
                    u.getEmail()));

        }
        return listUserDTO;
    }

}
