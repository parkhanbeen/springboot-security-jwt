package com.jwt.example.token.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "refresh_token")
@Entity
public class RefreshToken {

  @Id
  private String key;

  private String token;

  public RefreshToken updateValue(String token) {
    this.token = token;
    return this;
  }

  @Builder
  public RefreshToken(String key, String token) {
    this.key = key;
    this.token = token;
  }
}
