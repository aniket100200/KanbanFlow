package jwtexample3.example.kanbanflow.dtos.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    String jwtToken;
    String username;
    String email;
    String firstName;
    String lastName;
    String roles;
    String message;
    String userId;
}
