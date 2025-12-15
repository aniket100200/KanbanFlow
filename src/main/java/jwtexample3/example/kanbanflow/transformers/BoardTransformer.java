package jwtexample3.example.kanbanflow.transformers;

import jwtexample3.example.kanbanflow.dtos.request.BoardRequestDao;
import jwtexample3.example.kanbanflow.dtos.response.BoardResponseDao;
import jwtexample3.example.kanbanflow.dtos.response.TaskColumnResponseDto;
import jwtexample3.example.kanbanflow.models.Board;

import java.util.List;
import java.util.stream.Collectors;

public class BoardTransformer {
    public static Board boardRequestDaoToBoard(BoardRequestDao boardRequestDao){
        return Board.builder()
                .name(boardRequestDao.getName())
                        .ownerId(boardRequestDao.getOwnerId()).
                build();
    }

    public static BoardResponseDao boardToBoardResponseDao(Board board){

        List<TaskColumnResponseDto> columns = board.getColumns().stream().map(TaskColumnTransformer::taskColumnResponseDtoFromTaskColumn).collect(Collectors.toList());
        return BoardResponseDao.
                builder().
                id(board.getId()).
                name(board.getName()).
                ownerId(board.getOwnerId()).
                userId(board.getUser().getId()).
                columns(columns).
                build();
    }
}
