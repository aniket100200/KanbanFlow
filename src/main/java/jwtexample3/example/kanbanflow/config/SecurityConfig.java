package jwtexample3.example.kanbanflow.config;

import jwtexample3.example.kanbanflow.models.User;
import jwtexample3.example.kanbanflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        //this is functional interface for UserDetailsService. which has method load User by username
        return (username)->{

            User user = userRepository.findByPhone(username);
            if (user == null) {
                throw new UsernameNotFoundException(username+" not found");
            }
            return new UserDetailsCreator(user);
        };
    }
    //to create this class and Security filter chain just use the Spring Architecture official documentation

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
       //CSRF -> Cross site Request Forgery
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(req->req.requestMatchers("/public/**").permitAll().
                                                                                requestMatchers("/user/getMessage").permitAll().
                                                                                requestMatchers("/user/create").permitAll().
                                                                                requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
                                                                                .anyRequest().authenticated())
                .formLogin(form-> {
                    //YOU CAN SET YOUR  login page
                });
        return http.build();

    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        //DAO-> DATA Access Object
        //give it UserDetailService
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return daoAuthenticationProvider;
    }
}
