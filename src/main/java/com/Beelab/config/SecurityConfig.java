package com.Beelab.config;

import com.Beelab.Enum.Permissions;
import com.Beelab.config.jwt.AuthEntryPointJwt;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
        (prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@AllArgsConstructor
public class SecurityConfig {
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler));
        http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(daoAuthenticationProvider());
        http.authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority(Permissions.ADMIN_DASHBOARD.toString());
                    authConfig.anyRequest().permitAll();
                }).rememberMe(rememberMe -> {
                    rememberMe.key("remember-me");
                    rememberMe.tokenValiditySeconds(7 * 24 * 60 * 60); // 7 days
                    rememberMe.tokenRepository(persistentTokenRepository());
                }).formLogin(login -> {
                    login.loginPage("/auth/login");
                    login.failureUrl("/auth/login?error=true");
                    login.defaultSuccessUrl("/");
                }).logout(logout -> {
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                    logout.logoutSuccessUrl("/");
                    logout.deleteCookies("JSESSIONID");
                    logout.invalidateHttpSession(true);
                })
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        var tokenRepository = new JdbcTokenRepositoryImpl();
        //tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

}
