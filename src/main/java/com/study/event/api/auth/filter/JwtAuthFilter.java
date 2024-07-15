package com.study.event.api.auth.filter;

import com.study.event.api.auth.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 클라이언트가 요청에 포함한 토큰정보를 검사하는 필터
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        try {
            // 요청 메세지에서 토큰을 파싱
            // 토큰정보는 요청헤더에 포함되어 전송됨
            String token = parseBearerToken(request);

            if(token != null) {
                // 토큰 위조 검사
                tokenProvider.validateAndGetTokenInfo(token);
            }

        } catch (Exception e) {

        }
    }

    private String parseBearerToken(HttpServletRequest request) {
        /*
            1. 요청헤더에서 토큰을 가져오기
            --request header
            {
                'Authoriztion' : 'Bearer dfdfsadfasdfsdfdsfds',
                'Content-type' : 'application/json'
            }
         */
        String bearerToken = request.getHeader("Authorization");

        // 토큰에 붙어있는 Bearer라는 문자열을 제거
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // 7번부터 끝까지
        }
        return null;
    }
}
