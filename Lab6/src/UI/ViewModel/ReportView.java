package UI.ViewModel;

import DAL.Entities.Worker;
import DAL.InfoStructure.IEntity;

import java.util.Calendar;

public class ReportView {
    private int id;
    private WorkerView owner;
    private Calendar startTime;
    private Calendar endTime;
    private String text;

    public ReportView(WorkerView owner, Calendar endTime) {
        this.owner = owner;
        this.startTime = Calendar.getInstance();
        this.endTime = endTime;

    }

    public ReportView(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public WorkerView getOwner() {
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

    public void setOwner(WorkerView owner) {
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

