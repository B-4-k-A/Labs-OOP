package DAL;

import DAL.Entities.Change.Change;
import DAL.Entities.Change.ChangeComment;
import DAL.Entities.Change.ChangeOwner;
import DAL.Entities.Change.ChangeState;
import DAL.Entities.Comment;
import DAL.Entities.Task;
import DAL.Entities.Worker;
import DAL.InfoStructure.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements ITaskRepository {
    private List<Task> taskList = new ArrayList<>();
    private List<Change> changes = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        task.setId(taskList.size() + 1) ;
        taskList.add(task);
    }

    @Override
    public Task getTask(Task item) throws Exception {
        Optional<Task> option = taskList.stream().
                filter(task -> task.getId() == item.getId()).findFirst();
        if (option.isEmpty()) {
            throw new Exception("TaskDTO wasn't found");
        }
        return option.get();
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList(taskList);
    }

    public void deleteTask(Task task) throws Exception {
        var t = getTask(task);
        taskList.remove(t);

    }
    @Override
    public void changeState(Task task, int state) throws Exception {
        if(Math.abs(state) > 1) {
            throw new Exception("Incorrect value of state");
        }
        var t = getTask(task);
        var changer = new ChangeState(t);
        changer.changeState(state);
        changes.add(changer);
    }

    @Override
    public void setOwner(Task task, Worker item) throws Exception {
        if(item == null) {
            throw new NullPointerException();
        }
        var t = getTask(task);
        var changer = new ChangeOwner(t);
        changer.changeOwner(item);
        changes.add(changer);
    }


    public void addComment(Task task, Comment item) throws Exception {
        if(item == null) {
            throw new NullPointerException();
        }
        var t = getTask(task);
        var changer = new ChangeComment(t);
        changer.addComment(item);
        changes.add(changer);
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void doWork(Task task, Worker worker) throws Exception {
        getTask(task).doWork(worker);
    }

}
