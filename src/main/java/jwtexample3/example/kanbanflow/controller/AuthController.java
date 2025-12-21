package jwtexample3.example.kanbanflow.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jwtexample3.example.kanbanflow.config.JwtHelper;
import jwtexample3.example.kanbanflow.dtos.request.JwtRequest;
import jwtexample3.example.kanbanflow.dtos.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request, HttpServletResponse response){
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        String token = this.helper.generateToken(userDetails);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);      // Important: JS cannot read this
        cookie.setSecure(false);       // Set to true in production (HTTPS)
        cookie.setPath("/");           // Available for all routes
        cookie.setMaxAge(3*24*60*60); // 3 days expiration

        response.addCookie(cookie);
        JwtResponse jwtResponse = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@CookieValue(name = "token", defaultValue = "") String token) {
        if(token.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No token found");
        }

        // Use your existing public method
        Date expirationDate = helper.getExpirationDateFromToken(token);

        // Check if current date is after expiration date
        if (expirationDate.before(new Date())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired");
        }


        String username = helper.getUsernameFromToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return ResponseEntity.ok(userDetails);


    }


//    @GetMapping("/me")
//    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
//        // 'userDetails' is the authenticated user coming from Spring's internal storage
//        if (userDetails == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return ResponseEntity.ok(userDetails);
//    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }


    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
