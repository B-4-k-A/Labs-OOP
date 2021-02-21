package BLL.InfoStructure;

import BLL.DTO.CommentDTO;
import BLL.DTO.TaskDTO;
import BLL.DTO.WorkerDTO;

import java.util.Calendar;
import java.util.List;

public interface ITaskService {

    void addTask(TaskDTO item);

    TaskDTO getTask(TaskDTO item) throws Exception;

    boolean taskExists(TaskDTO task);

    void setOwner(TaskDTO task, WorkerDTO worker) throws Exception;

    void changeState(TaskDTO task, int i) throws Exception;

    void addComment(TaskDTO task, CommentDTO comment) throws Exception;

    Calendar stateDate(TaskDTO task);

    Calendar ownerDate(TaskDTO task);

    Calendar commentDate(TaskDTO task);

    List<TaskDTO> getTaskByPeriod(WorkerDTO worker, Calendar startTime, Calendar endTime);

    void doWork(TaskDTO task, WorkerDTO worker) throws Exception;
}
