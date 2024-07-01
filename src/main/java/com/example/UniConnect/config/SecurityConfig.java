
package com.example.UniConnect.config;

import com.example.UniConnect.enums.Roles;
import com.example.UniConnect.services.CustomUserDetailsService;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            return auth.getName();
        }
        return null;
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(daoAuthenticationProvider());

        http.csrf((csrf -> csrf.disable()))
                .authorizeHttpRequests(auth ->
                                auth.requestMatchers("post/create", "post/create-now", "/post/comment-create", "/post/delete/*",
                                        "/post/delete/*", "/post/favorites", "/post/favorite-create", "/post/comment/delete/*").authenticated()
                                        .requestMatchers("/admin").hasAnyRole("USER")
                                        .anyRequest().permitAll()
                )

                .formLogin(login ->
                        login.usernameParameter("username")
                                .loginPage("/login")
                                .loginProcessingUrl("/login-now")
                                .defaultSuccessUrl("/")
                                .permitAll()
                )
                                .logout(logout ->
                                        logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }

}
