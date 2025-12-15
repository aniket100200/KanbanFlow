package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.dtos.request.BoardRequestDao;
import jwtexample3.example.kanbanflow.dtos.response.BoardResponseDao;
import jwtexample3.example.kanbanflow.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImp implements BoardService {
    @Override
    public void deleteBoard(String boardUuid) {

    }

    @Override
    public BoardResponseDao createBoard(BoardRequestDao requestDao) {
        return null;
    }

    @Override
    public BoardResponseDao updateBoard(BoardRequestDao requestDao, String boardUuid) {
        return null;
    }

    @Override
    public BoardResponseDao getBoard(String boardUuid) {
        return null;
    }

    @Override
    public List<BoardResponseDao> getAllBoards(String userUuid) {
        return List.of();
    }
}
