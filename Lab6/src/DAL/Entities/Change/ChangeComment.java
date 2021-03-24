package DAL.Entities.Change;

import DAL.Entities.Comment;
import DAL.Entities.Task;

import java.util.Calendar;
import java.util.List;

public class ChangeComment extends Change{

    private Comment newComment;

    public ChangeComment(Task task) {
        super(task);
    }

    public void addComment(Comment comment) {
        newComment = comment;
        task.getCommentList().add(comment);
    }

    public void undo() {
        task.getCommentList().remove(newComment);
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
