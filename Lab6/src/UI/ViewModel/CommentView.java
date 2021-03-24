package UI.ViewModel;


import BLL.DTO.WorkerDTO;

import java.util.Calendar;

public class CommentView {
    private final WorkerDTO author;
    private final Calendar date;
    private final String text;

    public CommentView(WorkerDTO author, String text) {
        this.author = author;
        this.date = Calendar.getInstance();
        this.text = text;
    }

    public WorkerDTO getAuthor() {
        return author;
    }

    public Calendar getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
