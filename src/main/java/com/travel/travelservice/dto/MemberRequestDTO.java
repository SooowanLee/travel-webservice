package com.travel.travelservice.dto;

import com.travel.travelservice.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDTO {
    private String memberName;
    private String email;
    private String password;

    @Builder
    public MemberRequestDTO(String memberName, String email, String password) {
        this.memberName = memberName;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(MemberRequestDTO memberRequestDTO) {
        return Member.builder()
                .memberName(memberRequestDTO.getMemberName())
                .email(memberRequestDTO.getEmail())
                .password(memberRequestDTO.getPassword())
                .build();
    }
}
