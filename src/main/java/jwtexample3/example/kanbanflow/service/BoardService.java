package jwtexample3.example.kanbanflow.service;

import jwtexample3.example.kanbanflow.dtos.request.BoardRequestDao;
import jwtexample3.example.kanbanflow.dtos.response.BoardResponseDao;

import java.util.List;

public interface BoardService {
    BoardResponseDao createBoard(BoardRequestDao requestDao);
    void deleteBoard(String boardUuid);
    BoardResponseDao updateBoard(BoardRequestDao requestDao,String boardUuid);
    BoardResponseDao getBoard(String boardUuid);
    List<BoardResponseDao> getAllBoards(String userUuid);
}
