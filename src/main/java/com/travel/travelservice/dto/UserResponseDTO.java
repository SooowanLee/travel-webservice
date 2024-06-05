package com.travel.travelservice.dto;

import com.travel.travelservice.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String profile_image;

    @Builder
    public UserResponseDTO(Long id, String username, String email, String password, String profile_image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile_image = profile_image;
    }

    public static UserResponseDTO from(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .profile_image(user.getProfile_image())
                .build();
    }
}

