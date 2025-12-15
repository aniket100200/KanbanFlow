package jwtexample3.example.kanbanflow.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CardRequestDto {
    String title;
    String description;
    Double position;
    String columnId;
}
