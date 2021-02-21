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
