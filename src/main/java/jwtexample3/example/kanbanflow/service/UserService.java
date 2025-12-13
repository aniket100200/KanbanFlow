package jwtexample3.example.kanbanflow.service;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto,String uuid);
    UserResponseDto deleteUser(String uuid);
    UserResponseDto deleteUserByPhone(String phone);
    UserResponseDto deleteUserByEmail(String email);
    UserResponseDto getUser(UserRequestDto userRequestDto);
    UserResponseDto getUserByPhone(String phone);
    UserResponseDto getUserByEmail(UserRequestDto userRequestDto);

}
