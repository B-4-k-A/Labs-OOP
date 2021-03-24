package DAL.InfoStructure;

import DAL.Entities.Change.Change;
import DAL.Entities.Comment;
import DAL.Entities.Task;
import DAL.Entities.Worker;

import java.util.List;

public interface ITaskRepository {
    void addTask(Task task);

    Task getTask(Task task) throws Exception;

    List<Task> getAll();

    void deleteTask(Task task) throws Exception;

    void changeState(Task task, int state) throws Exception;

    void setOwner(Task task, Worker item) throws Exception;

    void addComment(Task task, Comment item) throws Exception;

    List<Change> getChanges();

    void doWork(Task task, Worker worker) throws Exception;
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
