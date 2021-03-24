package BLL;

import BLL.DTO.CommentDTO;
import BLL.DTO.TaskDTO;
import BLL.DTO.WorkerDTO;
import BLL.InfoStructure.ITaskService;
import DAL.Entities.Change.ChangeComment;
import DAL.Entities.Change.ChangeOwner;
import DAL.Entities.Change.ChangeState;
import DAL.Entities.Comment;
import DAL.Entities.Task;
import DAL.Entities.Worker;
import DAL.InfoStructure.ITaskRepository;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService implements ITaskService {

    private ITaskRepository repo;

    public TaskService(ITaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addTask(TaskDTO item) {
        var task = new Task(item.getName(), item.getDescription());
        repo.addTask(task);
        item.setId(task.getId());
    }

    @Override
    public TaskDTO getTask(TaskDTO item) throws Exception {
        var t = new Task(item.getId());
        var task =  repo.getTask(t);
        return new TaskDTO(task.getName(), task.getDescription());
    }

    @Override
    public boolean taskExists(TaskDTO task) {
        return repo.getAll().stream().anyMatch(
                t -> t.getId() == task.getId()
        );
    }

    @Override
    public void setOwner(TaskDTO task, WorkerDTO worker) throws Exception {
        var owner = new Worker(worker.getId());
        var t = new Task(task.getId());
        repo.setOwner(t, owner);
    }

    @Override
    public void changeState(TaskDTO task, int i) throws Exception {
        var owner = new Worker(task.getOwner().getId());
        var t = new Task(task.getId());
        repo.changeState(t, i);
    }

    @Override
    public void addComment(TaskDTO task, CommentDTO comment) throws Exception {
        var owner = new Worker(task.getOwner().getId());
        var t = new Task(task.getId());
        var w = new Worker(comment.getAuthor().getId());
        var c = new Comment(w, comment.getText());
        repo.addComment(t, c);
    }

    @Override
    public Calendar stateDate(TaskDTO task) {
        return repo.getChanges().stream().filter(o -> o instanceof ChangeState).
                map(o -> o.getTime()).findFirst().get();
    }

    @Override
    public Calendar ownerDate(TaskDTO task) {
        return repo.getChanges().stream().filter(o -> o instanceof ChangeOwner).
                map(o -> o.getTime()).findFirst().get();
    }

    @Override
    public Calendar commentDate(TaskDTO task) {
        return repo.getChanges().stream().filter(o -> o instanceof ChangeComment).
                map(o -> o.getTime()).findFirst().get();
    }

    @Override
    public List<TaskDTO> getTaskByPeriod(WorkerDTO worker, Calendar startTime, Calendar endTime) {
        return null;
    }

    public void doWork(TaskDTO task, WorkerDTO worker) throws Exception {
        var t = new Task(task.getId());
        var w = new Worker(worker.getId());
        repo.doWork(t, w);
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
