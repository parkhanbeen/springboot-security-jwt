package com.jwt.example.member;

import com.jwt.example.member.entity.Member;
import com.jwt.example.member.entity.MemberRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return memberRepository.findByEmail(username)
        .map(this::createUserDetails)
        .orElseThrow(
            () -> new UsernameNotFoundException(username + " -> db에서 찾을 수 없습니다."));
  }

  /**
   * 회원 정보가 존재한다면 UserDetails 객체를 반환합니다.
   *
   * @param member 회원 정보.
   * @return UserDetails 객체.
   */
  private UserDetails createUserDetails(Member member) {
    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getRoleType().toString());

    return new User(
        String.valueOf(member.getId()),
        member.getPassword(),
        Collections.singleton(grantedAuthority)
    );
  }
}
