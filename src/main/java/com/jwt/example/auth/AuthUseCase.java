package com.jwt.example.auth;

import com.jwt.example.token.dto.TokenDto;
import com.jwt.example.token.dto.TokenRequestDto;
import com.jwt.example.web.member.dto.MemberRequestDto;
import com.jwt.example.web.member.dto.MemberResponseDto;

public interface AuthUseCase {
  MemberResponseDto signup(MemberRequestDto memberRequestDto);

  TokenDto login(MemberRequestDto memberRequestDto);

  TokenDto reissue(TokenRequestDto tokenRequestDto);
}
