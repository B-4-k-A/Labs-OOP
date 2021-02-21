package BLL.DTO;


import java.util.Calendar;

public class CommentDTO {
    private final WorkerDTO author;
    private final Calendar date;
    private final String text;

    public CommentDTO(WorkerDTO author, String text) {
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
