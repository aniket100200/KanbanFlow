package jwtexample3.example.kanbanflow.service.Imp;

import jakarta.persistence.JoinColumn;
import jwtexample3.example.kanbanflow.customExceptions.CardNotFoundException;
import jwtexample3.example.kanbanflow.customExceptions.TaskColumnNotFoundException;
import jwtexample3.example.kanbanflow.dtos.request.CardRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;
import jwtexample3.example.kanbanflow.models.Card;
import jwtexample3.example.kanbanflow.models.TaskColumn;
import jwtexample3.example.kanbanflow.repository.CardRepository;
import jwtexample3.example.kanbanflow.repository.TaskColumnRepository;
import jwtexample3.example.kanbanflow.service.CardService;
import jwtexample3.example.kanbanflow.transformers.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImp implements CardService {
    private final BoardServiceImp boardServiceImp;

    @Autowired
    private TaskColumnRepository taskColumnRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImp(BoardServiceImp boardServiceImp) {
        this.boardServiceImp = boardServiceImp;
    }

    @Override
    public CardResponseDto createCard(CardRequestDto cardRequestDto) {
        Card card = CardTransformer.cardFromCardDto(cardRequestDto);
        //set column card.
        taskColumnRepository.findById(cardRequestDto.getColumnId()).ifPresent(card::setColumn);
        if(card.getColumn()==null)throw new TaskColumnNotFoundException("Column not found");

        //ready to save
         card  = cardRepository.save(card);

        return CardTransformer.cardToCardResponseDto(card);
    }

    @Override
    public void deleteCard(String cardUuid) {
        cardRepository.deleteById(cardUuid);
    }

    @Override
    public CardResponseDto updateCard(CardRequestDto cardRequestDto, String cardUuid) {
        Card card = cardRepository.findById(cardUuid).orElseThrow();
        if(card==null)throw new CardNotFoundException("Card not found");
        card.setTitle(cardRequestDto.getTitle());
        card.setDescription(cardRequestDto.getDescription());
        card.setPosition(cardRequestDto.getPosition());
        return null;
    }

    @Override
    public CardResponseDto getCard(String cardUuid) {
        Card card = cardRepository.findById(cardUuid).orElseThrow();
        if(card==null)throw new CardNotFoundException("Card not found");
        return CardTransformer.cardToCardResponseDto(card);
    }

}
