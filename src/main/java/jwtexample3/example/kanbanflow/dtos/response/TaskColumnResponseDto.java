package jwtexample3.example.kanbanflow.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskColumnResponseDto {
    String id;
    String title;
    Double position;
    String boardId;
    java.util.List<CardResponseDto> cards;
}
