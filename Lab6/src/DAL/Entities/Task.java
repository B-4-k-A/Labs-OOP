package DAL.Entities;

import DAL.InfoStructure.IEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Task implements IEntity {
    private int id;
    private String name;
    private String description;
    private Worker owner;
    private int state; // -1 = solved; 0 = open; 1 = active
    private Calendar creationDate;
    private Calendar changeDate;
    private List<Comment> commentList = new ArrayList<>();

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Worker getOwner() {
        return owner;
    }

    public int getState() {
        return state;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public Calendar getChangeDate() {
        return changeDate;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setChangeDate(Calendar changeDate) {
        this.changeDate = changeDate;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void doWork(Worker worker) {
        if(owner == null) {
            throw new NullPointerException("Worker isn't responsible");
        }
        //some Work, for initialize that method working print about it in console
        System.out.println("Worker working");
    }

    //    public void addComment(WorkerDTO author, String text) {
//        commentList.add(new CommentDTO(author, text));
//        changeDate = Calendar.getInstance();
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TaskDTO task = (TaskDTO) o;
//
//        return id.equals(task.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }

    //    public void doTask(WorkerDTO worker) throws Exception {
//        if(worker != owner) {
//            throw new Exception("you are not authorized to perform this task");
//        }
//        if(state == -1) {
//            throw new Exception("This task already have solved");
//        }
//        this.state = 1;
//        changeDate = Calendar.getInstance();
//        addComment(owner, "Worked");
//    }

//    public void finish() {
//        changeDate = Calendar.getInstance();
//        state = -1;
//    }


}



