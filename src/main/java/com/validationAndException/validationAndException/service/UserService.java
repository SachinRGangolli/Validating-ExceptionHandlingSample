package com.validationAndException.validationAndException.service;

import com.validationAndException.validationAndException.dto.UserDto;
import com.validationAndException.validationAndException.entity.User;
import com.validationAndException.validationAndException.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDto userDto){
        User user=User.build(0,userDto.getName(),userDto.getEmail(),userDto.getMobile(),
                userDto.getGender(),userDto.getAge(),userDto.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findByUserId(id);
    }
}
