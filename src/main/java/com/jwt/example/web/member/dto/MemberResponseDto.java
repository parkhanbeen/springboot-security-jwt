package com.jwt.example.web.member.dto;

import com.jwt.example.member.constant.RoleType;
import com.jwt.example.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
  private final String email;
  private final RoleType roleType;

  public MemberResponseDto(String email, RoleType roleType) {
    this.email = email;
    this.roleType = roleType;
  }

  public static MemberResponseDto of(Member member) {
    return new MemberResponseDto(member.getEmail(), member.getRoleType());
  }
}
