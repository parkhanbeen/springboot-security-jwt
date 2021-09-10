package com.jwt.example.member;

import com.jwt.example.web.member.dto.MemberResponseDto;

public interface MemberUseCase {
  MemberResponseDto find(String email);
}
