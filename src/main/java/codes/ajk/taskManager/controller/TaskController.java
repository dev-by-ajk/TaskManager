package codes.ajk.taskManager.controller;
// TaskController.java (REST API)

import codes.ajk.taskManager.entity.Task;
import codes.ajk.taskManager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        return  taskService.getTaskById(id);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

//    @PostMapping
//    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskdto) {
//        TaskDto saveTask = taskService.createTask(taskdto);
//        return new ResponseEntity<>(saveTask,HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
