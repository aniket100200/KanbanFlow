package jwtexample3.example.kanbanflow.transformers;

import jwtexample3.example.kanbanflow.dtos.request.TaskColumnRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;
import jwtexample3.example.kanbanflow.dtos.response.TaskColumnResponseDto;
import jwtexample3.example.kanbanflow.models.Card;
import jwtexample3.example.kanbanflow.models.TaskColumn;

import java.util.ArrayList;
import java.util.List;

public class TaskColumnTransformer {
    public static TaskColumnResponseDto taskColumnResponseDtoFromTaskColumn(TaskColumn taskColumn){
        List<CardResponseDto> cards = new ArrayList<>();
        for(Card card : taskColumn.getCards()){
            cards.add(CardTransformer.cardToCardResponseDto(card));
        }
        return TaskColumnResponseDto.builder()
                .id(taskColumn.getId()).
                title(taskColumn.getTitle()).
                cards(cards).
        build() ;
    }

    public static TaskColumn taskColumnRequestDtoToTaskColumn(TaskColumnRequestDto taskColumnRequestDto){
        return TaskColumn.builder().title(taskColumnRequestDto.getTitle()).build();
    }
}
