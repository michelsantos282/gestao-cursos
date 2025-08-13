package br.com.mdsantos.gestao_cursos.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/auth/**",
            "/users/"
    };

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                auth -> {
                    auth.requestMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated();
                }
        ).addFilterBefore(this.securityFilter, BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
