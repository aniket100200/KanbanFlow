package jwtexample3.example.kanbanflow.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    String email;
    String password;
}
