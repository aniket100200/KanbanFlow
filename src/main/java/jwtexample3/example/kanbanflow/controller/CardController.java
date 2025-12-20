package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.request.CardRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.CardResponseDto;
import jwtexample3.example.kanbanflow.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public ResponseEntity createCard(CardRequestDto requestDto){
        CardResponseDto res = cardService.createCard(requestDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCard(@PathVariable("id") String id){
        CardResponseDto res = cardService.getCard(id);
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/update")
    public ResponseEntity updateCard(@RequestBody CardRequestDto requestDto, @RequestParam("cardUuid") String cardUuid){
        CardResponseDto res = cardService.updateCard(requestDto,cardUuid);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{cardUuid}")
    public ResponseEntity deleteCard(@PathVariable("cardUuid") String cardUuid){
        cardService.deleteCard(cardUuid);
        return ResponseEntity.ok().build();
    }
}
