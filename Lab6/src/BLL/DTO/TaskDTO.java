package BLL.DTO;


import DAL.Entities.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaskDTO {
    private int id;
    private String name;
    private String description;
    private WorkerDTO owner;
    private int state; // -1 = solved; 0 = open; 1 = active
    private Calendar creationDate;
    private Calendar changeDate;
    private List<CommentDTO> commentList = new ArrayList<>();

    public TaskDTO(String name, String description) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public TaskDTO(int id) {
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

    public WorkerDTO getOwner() {
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

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(WorkerDTO owner) {

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

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
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



