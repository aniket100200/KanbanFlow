package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.ExceptionResponseDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequestDto userRequestDto) {
        try {
            UserResponseDto responceDto = userService.createUser(userRequestDto);
            return new ResponseEntity(responceDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity updateUser(UserRequestDto userRequestDto) {

        return null;
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity deleteUser(@PathVariable("uuid") String uuid) {
        return null;
    }

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello World!!");
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }


}
