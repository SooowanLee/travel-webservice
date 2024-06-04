package com.travel.travelservice.service;

import com.travel.travelservice.domain.User;
import com.travel.travelservice.dto.UserRequestDTO;
import com.travel.travelservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long save(UserRequestDTO userDTO) {
        User user = userDTO.toEntity(userDTO);
        return user.getId();
    }


}
