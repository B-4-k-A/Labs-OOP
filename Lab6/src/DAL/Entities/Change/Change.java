package DAL.Entities.Change;

import DAL.Entities.Task;

import java.util.Calendar;

public class Change {
    protected Task task;
    protected Calendar time;

    public Change(Task task) {
        this.task = task;
        this.time = Calendar.getInstance();
    }

    public Task getTask() {
        return task;
    }

    public Calendar getTime() {
        return time;
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
