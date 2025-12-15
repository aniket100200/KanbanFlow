package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.dtos.request.TaskColumnRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.TaskColumnResponseDto;
import jwtexample3.example.kanbanflow.models.Board;
import jwtexample3.example.kanbanflow.models.TaskColumn;
import jwtexample3.example.kanbanflow.repository.BoardRepository;
import jwtexample3.example.kanbanflow.repository.TaskColumnRepository;
import jwtexample3.example.kanbanflow.service.TaskColumnService;
import jwtexample3.example.kanbanflow.transformers.TaskColumnTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskColumnServiceImp implements TaskColumnService {

    private final BoardRepository boardRepository;
    private final TaskColumnRepository taskColumnRepository;

    @Autowired
    public TaskColumnServiceImp(BoardRepository boardRepository, TaskColumnRepository taskColumnRepository) {
        this.boardRepository = boardRepository;
        this.taskColumnRepository = taskColumnRepository;
    }
    @Override
    public TaskColumnResponseDto createTaskColumn(TaskColumnRequestDto requestDto) {
        TaskColumn taskColumn = TaskColumnTransformer.taskColumnRequestDtoToTaskColumn(requestDto);

        Board board = boardRepository.findById(requestDto.getBoardId()).orElseThrow();

        taskColumn.setBoard(board);
        taskColumn.setCards(new java.util.ArrayList<>());

        TaskColumn savedTaskColumn= taskColumnRepository.save(taskColumn);

        return TaskColumnTransformer.taskColumnResponseDtoFromTaskColumn(savedTaskColumn);
    }

    @Override
    public void deleteTaskColumn(String taskColumnUuid) {
        taskColumnRepository.deleteById(taskColumnUuid);
    }

    @Override
    public TaskColumnResponseDto updateTaskColumn(TaskColumnRequestDto requestDto, String taskColumnUuid) {
        TaskColumn taskColumn = taskColumnRepository.findById(taskColumnUuid).orElseThrow();
        taskColumn.setTitle(requestDto.getTitle());
        //we'll see it later
       // taskColumn.setCards(new java.util.ArrayList<>());

        taskColumn = taskColumnRepository.save(taskColumn);
        return null;
    }

    @Override
    public TaskColumnResponseDto getTaskColumn(String taskColumnUuid) {
        TaskColumn taskColumn = taskColumnRepository.findById(taskColumnUuid).orElseThrow();

        return TaskColumnTransformer.taskColumnResponseDtoFromTaskColumn(taskColumn);
    }

    @Override
    public List<TaskColumnResponseDto> getAllTaskColumns() {
        return taskColumnRepository.findAll().stream().map(TaskColumnTransformer::taskColumnResponseDtoFromTaskColumn).toList();
    }

    @Override
    public List<TaskColumnResponseDto> getAllTaskColumnsByBoardId(String boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        List<TaskColumn> taskColumns = board.getColumns();
        if(taskColumns!=null)return taskColumns.stream().map(TaskColumnTransformer::taskColumnResponseDtoFromTaskColumn).toList();
        return List.of();
    }
}
