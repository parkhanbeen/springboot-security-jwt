package com.jwt.example.web.auth;

import com.jwt.example.token.dto.TokenDto;
import com.jwt.example.token.dto.TokenRequestDto;
import com.jwt.example.auth.AuthService;
import com.jwt.example.web.member.dto.MemberRequestDto;
import com.jwt.example.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthRestController {
  private final AuthService authService;

  @PostMapping("/auth/signup")
  public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
    return ResponseEntity.ok(authService.signup(memberRequestDto));
  }

  @PostMapping("/auth/login")
  public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
    return ResponseEntity.ok(authService.login(memberRequestDto));
  }

  @PostMapping("/auth/reissue")
  public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
    return ResponseEntity.ok(authService.reissue(tokenRequestDto));
  }
}
