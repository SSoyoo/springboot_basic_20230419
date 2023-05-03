package com.soyoo.firstproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.soyoo.firstproject.provider.JwtTokenProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException { //HTTP 요청에 대한 필터링을 처리

                try {
                    
                    String jwt = parseToken(request); // 토큰을 가져오고 유효한지 확인 
                    boolean hasJwt = jwt != null;
                    if(!hasJwt) {
                        filterChain.doFilter(request, response);
                        return;  
                    }

                    String subject = jwtTokenProvider.validate(jwt); // 서브젝트를 가져올 수 있음
                    AbstractAuthenticationToken authenticationToken = 
                        new UsernamePasswordAuthenticationToken(subject, null, AuthorityUtils.NO_AUTHORITIES);

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 이건 또 뭐하는건데 
                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                    securityContext.setAuthentication(authenticationToken); //그래서 뭐하는건지 설명 좀 해라고...

                    SecurityContextHolder.setContext(securityContext);


                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        
                filterChain.doFilter(request, response);
    }

    private String parseToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        boolean hasToken = 
            token != null && 
            !token.equalsIgnoreCase("null");
        if (!hasToken) return null;

        boolean isBearer = token.startsWith("Bearer ");
        if (!isBearer) return null;

        String jwt = token.substring(7);
        return jwt;

    }
    
}
