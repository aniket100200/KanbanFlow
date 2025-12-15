package jwtexample3.example.kanbanflow.service;

import jwtexample3.example.kanbanflow.dtos.request.TaskColumnRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.TaskColumnResponseDto;

import java.util.List;

public interface TaskColumnService {
    TaskColumnResponseDto createTaskColumn(TaskColumnRequestDto requestDto);
    void deleteTaskColumn(String taskColumnUuid);
    TaskColumnResponseDto updateTaskColumn(TaskColumnRequestDto requestDto,String taskColumnUuid);
    TaskColumnResponseDto getTaskColumn(String taskColumnUuid);
    List<TaskColumnResponseDto> getAllTaskColumns();
    List<TaskColumnResponseDto> getAllTaskColumnsByBoardId(String boardId);
}
