package jwtexample3.example.kanbanflow.transformers;

import jwtexample3.example.kanbanflow.dtos.request.CardRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;
import jwtexample3.example.kanbanflow.models.Card;

public class CardTransformer {
    public static Card cardFromCardDto(CardRequestDto cardDto){
        return Card.builder()
                .title(cardDto.getTitle())
                .description(cardDto.getDescription())
                .position(cardDto.getPosition())
                .build();
    }

    public static CardResponseDto cardToCardResponseDto(Card card){
        return CardResponseDto.
                builder()
                .id(card.getId())
                .title(card.getTitle())
                .description(card.getDescription())
                .columnId(card.getColumn().getId())
                .position(card.getPosition())
                .build();
    }
}
