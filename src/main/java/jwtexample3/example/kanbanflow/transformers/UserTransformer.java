package jwtexample3.example.kanbanflow.transformers;

import jwtexample3.example.kanbanflow.dtos.request.UserRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.UserResponseDto;
import jwtexample3.example.kanbanflow.models.User;

public class UserTransformer {
    public static User getUserFromRequest(UserRequestDto userRequestDto) {
        return User.builder()
                .email(userRequestDto.getEmail())
                .phone(userRequestDto.getPhone())
                .state(userRequestDto.getState())
                .city(userRequestDto.getCity())
                .address(userRequestDto.getAddress())
                .lastName(userRequestDto.getLastName())
                .firstName(userRequestDto.getFirstName())
                .password(userRequestDto.getPassword())
                .build();
    }

    public static UserResponseDto getUserResponseDto(User user) {
        return UserResponseDto
                .builder()
                .id(user.getId())
                .city(user.getCity())
                .street(user.getAddress())
                .address(user.getAddress())
                .phone(user.getPhone())
                .state(user.getState())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName()).roles(user.getRoles()).build();
    }


    public static User getUpdatedUser(User user, UserRequestDto userRequestDto) {
        if(userRequestDto.getFirstName()!=null)user.setFirstName(userRequestDto.getFirstName());
        if(userRequestDto.getLastName()!=null)user.setLastName(userRequestDto.getLastName());
        if(userRequestDto.getEmail()!=null)user.setEmail(userRequestDto.getEmail());
        if(userRequestDto.getPhone()!=null)user.setPhone(userRequestDto.getPhone());
        if(userRequestDto.getState()!=null)user.setState(userRequestDto.getState());
        if(userRequestDto.getCity()!=null)user.setCity(userRequestDto.getCity());
        if(userRequestDto.getAddress()!=null)user.setAddress(userRequestDto.getAddress());

        return user;
    }
}
