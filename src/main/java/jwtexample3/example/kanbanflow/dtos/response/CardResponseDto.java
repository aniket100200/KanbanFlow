package jwtexample3.example.kanbanflow.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponseDto {
    String id;
    String title;
    String description;
    Double position;
    String columnId;
}
