package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.enums.Role;
import jwtexample3.example.kanbanflow.models.User;
import jwtexample3.example.kanbanflow.transformers.UserTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/user")
    public UserResponseDto getUser() {
        User user = new User();
        user.setRoles(Set.of(Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_VIEWER));
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        return UserTransformer.getUserResponseDto(user);
    }
}
