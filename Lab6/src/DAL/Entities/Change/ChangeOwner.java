package DAL.Entities.Change;

import DAL.Entities.Task;
import DAL.Entities.Worker;

import java.util.Calendar;

public class ChangeOwner extends Change{

    private Worker prevOwner;

    public ChangeOwner(Task task) {
        super(task);
    }

    public void changeOwner(Worker newOwner) {
        prevOwner = task.getOwner();
        task.setOwner(newOwner);
    }

    public void undo() {
        task.setOwner(prevOwner);
    }
}
