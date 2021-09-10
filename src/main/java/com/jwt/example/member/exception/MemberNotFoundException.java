package com.jwt.example.member.exception;

/**
 * 회원 정보를 찾을 수 없는 경우 던지는 Exception.
 */
public class MemberNotFoundException extends RuntimeException {
  private static final String MESSAGE = "회원 정보를 email을 찾을 수 없습니다. [email = %s]";

  public MemberNotFoundException(String email) {
    super(String.format(MESSAGE, email));
  }
}
