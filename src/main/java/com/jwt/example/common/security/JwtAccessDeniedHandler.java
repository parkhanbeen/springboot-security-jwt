package com.jwt.example.common.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

  /**
   * 필요한 권한이 없이 접근하려 할때 403 에러를 반환합니다.
   */
  @Override
  public void handle(HttpServletRequest request,
                     HttpServletResponse response,
                     AccessDeniedException accessDeniedException)
      throws IOException, ServletException {
    response.sendError(HttpServletResponse.SC_FORBIDDEN);
  }
}
