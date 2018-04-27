package com.hunsy.pointshop.commons.filter;

import com.hunsy.pointshop.commons.utils.ApplicationContextUtils;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.service.DeveloperService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * 权限拦截器
 */
public class JWTAuthFilter extends BasicAuthenticationFilter {

    public JWTAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(token)) {
            // parse the token.
            try {
                String user = Jwts.parser()
                        .setSigningKey("MyJwtSecret")
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody()
                        .getSubject();

                if (user != null) {
                    AppDeveloper developer = ApplicationContextUtils.getBean(DeveloperService.class).findByMobile(user);
                    if (developer != null) {
                        return new UsernamePasswordAuthenticationToken(developer, null, Collections.emptyList());
                    }
                }
            } catch (ExpiredJwtException e) {
                return null;
            }
            return null;
        }
        return null;
    }
}
