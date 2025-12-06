package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.ExceptionResponseDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity createUser(UserRequestDto userRequestDto) {
        try {
            UserResponseDto responceDto = userService.createUser(userRequestDto);
            return new ResponseEntity(responceDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
