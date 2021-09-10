package com.jwt.example.web.member;

import com.jwt.example.member.MemberUseCase;
import com.jwt.example.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberRestController {
  private final MemberUseCase memberUseCase;

  @RequestMapping("/member/{email}")
  public ResponseEntity<MemberResponseDto> find(@PathVariable String email) {
    return ResponseEntity.ok(memberUseCase.find(email));
  }

}
