import java.time.LocalDateTime;

public class Task {
    public int id;
    public String description;
    public String status;
    public String createdAt;
    public String updatedAt;

    public Task(int id, String description){
        this.id=id;
        this.description=description;
        this.status="todo";
        this.createdAt= LocalDateTime.now().toString();
        this.updatedAt= this.createdAt;
    }
}
