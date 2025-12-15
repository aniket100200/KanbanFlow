package jwtexample3.example.kanbanflow.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardRequestDao {
    String name;
    String ownerId;
    String userId;
}
