package jwtexample3.example.kanbanflow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;


    @Autowired
    private JwtAuthenticationFilter filter;

    //to create this class and Security filter chain just use the Spring Architecture official documentation

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
       //CSRF -> Cross site Request Forgery
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(req->req.requestMatchers("/public/**").permitAll().
                        requestMatchers("/auth/login").permitAll()
                         .requestMatchers("/swagger-ui.html", "/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll().
                        requestMatchers("/user/getMessage").permitAll().
                        requestMatchers("/user/create").permitAll().
                        requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
                        .anyRequest().authenticated())
                .exceptionHandling(ex->ex.authenticationEntryPoint(point))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

}
