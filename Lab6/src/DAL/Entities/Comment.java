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
