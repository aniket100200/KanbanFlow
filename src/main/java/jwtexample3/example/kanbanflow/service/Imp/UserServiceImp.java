package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public String deleteUser(UserRequestDto userRequestDto) {
        return "";
    }

    @Override
    public UserResponseDto getUser(UserRequestDto userRequestDto) {
        return null;
    }
}
