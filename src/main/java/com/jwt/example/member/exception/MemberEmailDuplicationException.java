package com.jwt.example.member.exception;

/**
 * 이미 가입된 회원이 있을 경우 던지는 Exception.
 */
public class MemberEmailDuplicationException extends RuntimeException {
  private static final String MESSAGE = "이미 가입된 email이 있습니다. [email = %s]";

  public MemberEmailDuplicationException(String email) {
    super(String.format(MESSAGE, email));
  }

}
