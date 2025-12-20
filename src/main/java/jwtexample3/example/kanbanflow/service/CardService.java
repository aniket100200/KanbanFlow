package jwtexample3.example.kanbanflow.service;

import jwtexample3.example.kanbanflow.dtos.request.CardRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;

public interface CardService {
    CardResponseDto createCard(CardRequestDto cardRequestDto);
}
