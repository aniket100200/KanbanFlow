package jwtexample3.example.kanbanflow.dtos.request;

import jwtexample3.example.kanbanflow.models.TaskColumn;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardRequestDao {
    String name;
    String ownerId;
    String userId;
    java.util.List<TaskColumnRequestDto> columns;
}
