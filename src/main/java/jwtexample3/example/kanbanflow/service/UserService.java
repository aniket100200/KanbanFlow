package jwtexample3.example.kanbanflow.service;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto);
    String deleteUser(UserRequestDto userRequestDto);
    UserResponseDto getUser(UserRequestDto userRequestDto);

}
