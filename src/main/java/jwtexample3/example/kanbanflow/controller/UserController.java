package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.customExceptions.UserNotFoundException;
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
    public ResponseEntity updateUser(@RequestBody UserRequestDto userRequestDto, @RequestParam("uuid") String uuid) {
        try{
            UserResponseDto res = userService.updateUser(userRequestDto, uuid);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return new ResponseEntity(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity deleteUser(@PathVariable("uuid") String uuid) {
        try{
             UserResponseDto responseDto = userService.deleteUser(uuid);
             responseDto.setMessage("User deleted successfully");
            return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello World!!");
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/getByPhone")
    public ResponseEntity getUserByPhone(@RequestParam("phone") String phone) {
        try{
            UserResponseDto userResponseDto = userService.getUserByPhone(phone);
            return ResponseEntity.ok(userResponseDto);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
