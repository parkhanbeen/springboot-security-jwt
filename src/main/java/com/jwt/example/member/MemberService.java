package com.jwt.example.member;

import com.jwt.example.member.entity.MemberRepository;
import com.jwt.example.member.exception.MemberNotFoundException;
import com.jwt.example.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService implements MemberUseCase{
  private final MemberRepository memberRepository;

  /**
   * 이메일을 이용하여 사용자 정보를 반환합니다.
   *
   * @param email 이메일.
   * @return 회원 정보.
   * @throws MemberNotFoundException 회원 정보를 찾지 못했을 경우.
   */
  @Transactional(readOnly = true)
  @Override
  public MemberResponseDto find(String email) {
    return memberRepository.findByEmail(email)
        .map(MemberResponseDto::of)
        .orElseThrow(() -> new MemberNotFoundException(email));
  }
}
