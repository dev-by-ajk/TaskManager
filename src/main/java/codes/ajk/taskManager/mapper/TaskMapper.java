package codes.ajk.taskManager.mapper;

import codes.ajk.taskManager.dto.TaskDto;
import codes.ajk.taskManager.entity.Task;

public class TaskMapper {

    public static TaskDto maptToTaskDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.isCompleted());
    }

    public static Task maptoTask(TaskDto taskDto) {
        return new Task(taskDto.getId(), taskDto.getTitle(), taskDto.isCompleted());
    }
}
