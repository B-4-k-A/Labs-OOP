package UI;

import BLL.DTO.CommentDTO;
import BLL.DTO.TaskDTO;
import BLL.DTO.WorkerDTO;
import BLL.InfoStructure.ITaskService;
import UI.ViewModel.CommentView;
import UI.ViewModel.TaskView;
import UI.ViewModel.WorkerView;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class TaskController {
    private ITaskService service;

    public TaskController(ITaskService service) {
        this.service = service;
    }

    public void addTask(TaskView item) {
        var task = new TaskDTO(item.getId());
        service.addTask(task);
        item.setId(task.getId());
    }

    public TaskView getTask(TaskView item) throws Exception {
        var task = new TaskDTO(item.getId());
        service.getTask(task);
        return new TaskView(task.getName(), task.getDescription());
    }

    public void setOwner(TaskView task, WorkerView worker) throws Exception {
        var t = new TaskDTO(task.getId());
        var w = new WorkerDTO(worker.getId());
        service.setOwner(t, w);
    }

    public void changeState(TaskView task, int i) throws Exception {
        var t = new TaskDTO(task.getId());
        service.changeState(t, i);
    }

    public void addComment(TaskView task, CommentView comment) throws Exception {
        var t = new TaskDTO(task.getId());
        var c = new CommentDTO(comment.getAuthor(), comment.getText());
        service.addComment(t, c);
    }

    public Calendar getStateDate(TaskView task) {
        var t = new TaskDTO(task.getId());
        return service.stateDate(t);
    }

    public Calendar getOwnerDate(TaskView task) {
        var t = new TaskDTO(task.getId());
        return service.ownerDate(t);
    }

    public Calendar getCommentDate(TaskView task) {
        var t = new TaskDTO(task.getId());
        return service.commentDate(t);
    }

    public List<TaskView> getTaskByPeriod(WorkerView worker, Calendar startTime, Calendar endTime) {
        var w = new WorkerDTO(worker.getId());
        return service.getTaskByPeriod(w, startTime, endTime).stream().
                map(o -> new TaskView(o.getName(), o.getDescription()))
                .collect(Collectors.toList());
    }

    public void doWork(TaskView task, WorkerView worker) throws Exception {
        var t = new TaskDTO(task.getId());
        var w = new WorkerDTO(worker.getId());
        service.doWork(t, w);
    }

}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
