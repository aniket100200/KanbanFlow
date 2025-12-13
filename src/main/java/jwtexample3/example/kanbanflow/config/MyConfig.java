package jwtexample3.example.kanbanflow.config;

import jwtexample3.example.kanbanflow.models.User;
import jwtexample3.example.kanbanflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        //this is functional interface for UserDetailsService. which has method load User by username
        return (username)->{

            User user = userRepository.findByEmail(username);
            if (user == null) {
                throw new UsernameNotFoundException(username+" not found");
            }
            return new UserDetailsCreator(user);
        };
    }

//    @Bean
//    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
//        //DAO-> DATA Access Object
//        //give it UserDetailService
//        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider(getUserDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
//        return daoAuthenticationProvider;
//    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
