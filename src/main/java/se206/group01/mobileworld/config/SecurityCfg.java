package se206.group01.mobileworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import se206.group01.mobileworld.service.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityCfg {
    @Bean
    JpaUserDetailsService uds() {
        return new JpaUserDetailsService();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .userDetailsService(uds())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/profile", "/cart").authenticated()
                        .anyRequest().permitAll())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login-validate")
                        .failureUrl("/login?failed")
                        .permitAll())
                .build();
    }
}
