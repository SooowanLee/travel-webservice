package com.travel.travelservice.service;

import com.travel.travelservice.domain.User;
import com.travel.travelservice.dto.UserRequestDTO;
import com.travel.travelservice.dto.UserResponseDTO;
import com.travel.travelservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long save(UserRequestDTO userDTO) {
        User user = userDTO.toEntity(userDTO);

        return userRepository.save(user).getId();
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 유저입니다."));

        return UserResponseDTO.from(user);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserResponseDTO.from(user))
                .collect(Collectors.toList());
    }
}
