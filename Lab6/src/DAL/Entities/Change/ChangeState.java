package DAL.Entities.Change;

import DAL.Entities.Task;

import java.util.Calendar;

public class ChangeState extends Change{

    private int prevState;

    public ChangeState(Task task) {
        super(task);
    }

    public void changeState(int i) throws Exception {
        if(Math.abs(i) > i) {
            throw new Exception("Incorrect state");
        }
        prevState = task.getState();
        task.setState(i);
    }

    public void undo() {
        task.setState(prevState);
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
