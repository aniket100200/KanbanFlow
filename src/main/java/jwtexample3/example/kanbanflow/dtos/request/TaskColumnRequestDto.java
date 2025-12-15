package jwtexample3.example.kanbanflow.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskColumnRequestDto {
    String title;
    Double position;
    String boardId;
    java.util.List<CardRequestDto> cards;
}
