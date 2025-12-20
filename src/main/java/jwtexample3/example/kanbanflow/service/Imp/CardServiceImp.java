package jwtexample3.example.kanbanflow.service.Imp;

import jakarta.persistence.JoinColumn;
import jwtexample3.example.kanbanflow.dtos.request.CardRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;
import jwtexample3.example.kanbanflow.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImp implements CardService {
    @Override
    public CardResponseDto createCard(CardRequestDto cardRequestDto) {
        return null;
    }
}
