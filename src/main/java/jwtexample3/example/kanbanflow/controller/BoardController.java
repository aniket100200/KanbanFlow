package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.request.BoardRequestDao;
import jwtexample3.example.kanbanflow.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "*")
public class BoardController {

    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public ResponseEntity createBoard(BoardRequestDao requestDao){
        return ResponseEntity.ok(boardService.createBoard(requestDao));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getBoard(@PathVariable("id") String id){
        return ResponseEntity.ok(boardService.getBoard(id));
    }


    @GetMapping("/getAll/{userUuid}")
    public ResponseEntity getAllBoards(@PathVariable("userUuid") String userUuid){
        return ResponseEntity.ok(boardService.getAllBoards(userUuid));
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity deleteBoard(@PathVariable("uuid") String uuid){
        boardService.deleteBoard(uuid);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/update")
    public ResponseEntity updateBoard(@RequestBody BoardRequestDao requestDao, @RequestParam("uuid") String uuid){
        return ResponseEntity.ok(boardService.updateBoard(requestDao,uuid));
    }
}
