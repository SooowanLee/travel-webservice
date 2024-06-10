package com.travel.travelservice.service;

import com.travel.travelservice.domain.Member;
import com.travel.travelservice.dto.MemberRequestDTO;
import com.travel.travelservice.dto.MemberResponseDTO;
import com.travel.travelservice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //이메일 검증
    public boolean isEmailExists(String email) {
        return memberRepository.existsByEmail(email);
    }

    public long save(MemberRequestDTO memberRequestDTO) {
        Member member = memberRequestDTO.toEntity(memberRequestDTO);

        return memberRepository.save(member).getId();
    }

    public MemberResponseDTO findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 유저입니다."));

        return MemberResponseDTO.from(member);
    }

    public List<MemberResponseDTO> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberResponseDTO.from(member))
                .collect(Collectors.toList());
    }
}
