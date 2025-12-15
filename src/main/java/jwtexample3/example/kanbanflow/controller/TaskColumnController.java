package jwtexample3.example.kanbanflow.controller;

import jwtexample3.example.kanbanflow.dtos.request.TaskColumnRequestDto;
import jwtexample3.example.kanbanflow.dtos.response.TaskColumnResponseDto;
import jwtexample3.example.kanbanflow.service.TaskColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskColumn")
@CrossOrigin(origins = "*")
public class TaskColumnController {
    private final TaskColumnService taskColumnService;

    @Autowired
    public TaskColumnController(TaskColumnService taskColumnService) {
        this.taskColumnService = taskColumnService;
    }

    @PostMapping("/create")
    public ResponseEntity createTaskColumn(TaskColumnRequestDto requestDto){
       TaskColumnResponseDto responseDto = taskColumnService.createTaskColumn(requestDto);
       return ResponseEntity.ok(responseDto);
    }


    @PatchMapping("/update")
    public ResponseEntity updateTaskColumn(@RequestBody TaskColumnRequestDto requestDto, @RequestParam("taskColumnUuid") String taskColumnUuid){
        TaskColumnResponseDto responseDto = taskColumnService.updateTaskColumn(requestDto,taskColumnUuid);

        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/delete/{column_id}")
    public ResponseEntity deleteTaskColumn(@PathVariable("column_id") String column_id){
        taskColumnService.deleteTaskColumn(column_id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/get/{column_id}")
    public ResponseEntity getTaskColumn(@PathVariable("column_id") String column_id){
        TaskColumnResponseDto responseDto = taskColumnService.getTaskColumn(column_id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllTaskColumns(){
        return ResponseEntity.ok(taskColumnService.getAllTaskColumns());
    }
}
