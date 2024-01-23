//package com.Beelab.config.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private JwtTokenProvider tokenProvider;
//
//    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider) {
//        this.tokenProvider = tokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        try {
//            String jwt = getJwtFromRequest(request);
//
//            if (jwt != null && tokenProvider.validateToken(jwt)) {
//                String username = tokenProvider.getUsernameFromToken(jwt);
//
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                        username, null, new ArrayList<>());
//
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        } catch (Exception e) {
//            logger.error("Could not set user authentication in security context", e);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//
//        return null;
//    }
//}
