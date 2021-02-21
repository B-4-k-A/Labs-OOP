package DAL.Entities;

import java.util.Calendar;

public class Report {
    private int id;
    private Worker owner;
    private Calendar startTime;
    private Calendar endTime;
    private String text;

    public Report(Worker owner, Calendar endTime) {
        this.owner = owner;
        this.startTime = Calendar.getInstance();
        this.endTime = endTime;

    }

    public Report(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Worker getOwner() {
        return owner;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public void setText(String text) {
        this.text = text;
    }
}

