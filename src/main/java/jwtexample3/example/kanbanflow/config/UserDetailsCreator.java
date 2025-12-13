package jwtexample3.example.kanbanflow.config;

import jwtexample3.example.kanbanflow.enums.Role;
import jwtexample3.example.kanbanflow.models.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsCreator implements UserDetails {

   String username;
   String password;
   List<GrantedAuthority> authorities ;

    public UserDetailsCreator(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = new  ArrayList<>();
        Set<Role> roles = user.getRoles();

        for (Role role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
            this.authorities.add(authority);
        }

    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}

