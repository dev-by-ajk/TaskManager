package codes.ajk.taskManager.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private boolean completed;
}
