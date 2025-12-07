package jwtexample3.example.kanbanflow.dtos.response;

import jwtexample3.example.kanbanflow.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    String id;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    String phone;
    String message;
    String street;
   Set<Role> roles;
}
