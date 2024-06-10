package com.travel.travelservice.dto;

import com.travel.travelservice.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDTO {

    private Long id;
    private String memberName;
    private String email;
    private String password;

    @Builder
    public MemberResponseDTO(Long id, String memberName, String email, String password) {
        this.id = id;
        this.memberName = memberName;
        this.email = email;
        this.password = password;
    }

    public static MemberResponseDTO from(Member member) {
        return MemberResponseDTO.builder()
                .id(member.getId())
                .memberName(member.getMemberName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}

