package com.travel.travelservice.controller;

import com.travel.travelservice.dto.MemberRequestDTO;
import com.travel.travelservice.dto.MemberResponseDTO;
import com.travel.travelservice.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //로그인 화면

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Long> signUp(@RequestBody MemberRequestDTO memberRequestDTO) {

        if (memberService.isEmailExists(memberRequestDTO.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        return ResponseEntity.ok(memberService.save(memberRequestDTO));
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @GetMapping("/member")
    public ResponseEntity<List<MemberResponseDTO>> getAllMember() {
        return ResponseEntity.ok(memberService.findAll());
    }
}
