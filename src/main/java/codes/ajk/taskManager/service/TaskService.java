package codes.ajk.taskManager.service;
// TaskService.java (Service Layer)

import codes.ajk.taskManager.dto.TaskDto;
import codes.ajk.taskManager.exception.ResourceNotFoundException;
import codes.ajk.taskManager.mapper.TaskMapper;
import codes.ajk.taskManager.entity.Task;
import codes.ajk.taskManager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"+id));
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.maptoTask(taskDto);
        Task saveTask = taskRepository.save(task);
        return TaskMapper.maptToTaskDto(saveTask);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new ResourceNotFoundException(id+ "Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

