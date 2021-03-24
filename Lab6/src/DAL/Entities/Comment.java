package DAL.Entities;

import DAL.InfoStructure.IEntity;

import java.util.Calendar;

public class Comment implements IEntity {
    private final Worker author;
    private final Calendar date;
    private final String text;

    public Comment(Worker author, String text) {
        this.author = author;
        this.date = Calendar.getInstance();
        this.text = text;
    }

    public Worker getAuthor() {
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
