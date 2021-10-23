package com.jwt.example.token.exception;

/**
 * 토큰에 권한 정보가 없을 경우 던지는 Exception.
 */
public class UnauthorizedTokenException extends RuntimeException {
  private static final String MESSAGE = "권한 정보가 없는 토큰 입니다.";

  public UnauthorizedTokenException() {
    super(MESSAGE);
  }
}
