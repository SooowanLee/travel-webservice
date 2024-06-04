package com.travel.travelservice.dto;

import com.travel.travelservice.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String username;
    private String email;
    private String password;
    private String profile_image;

    @Builder
    public UserRequestDTO(String username, String email, String password, String profile_image) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile_image = profile_image;
    }

    public User toEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .username(userRequestDTO.getUsername())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .profile_image(userRequestDTO.profile_image)
                .build();
    }
}
