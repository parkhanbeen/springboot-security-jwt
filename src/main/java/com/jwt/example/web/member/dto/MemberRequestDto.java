package com.jwt.example.web.member.dto;

import com.jwt.example.member.constant.RoleType;
import com.jwt.example.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Getter
public class MemberRequestDto {
  private String email;
  private String password;

  @Builder
  public MemberRequestDto(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Member toMember(PasswordEncoder passwordEncoder) {
    return Member.builder()
        .email(email)
        .password(passwordEncoder.encode(password))
        .roleType(RoleType.USER)
        .build();
  }

  public UsernamePasswordAuthenticationToken toAuthentication() {
    return new UsernamePasswordAuthenticationToken(email, password);
  }
}
