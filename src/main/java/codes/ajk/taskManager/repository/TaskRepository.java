package codes.ajk.taskManager.repository;
// TaskRepository.java (Repository)

import codes.ajk.taskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> { }

