package BLL.DTO;


import DAL.Entities.Report;

import java.util.Calendar;

public class ReportDTO {
    private int id;
    private WorkerDTO owner;
    private Calendar startTime;
    private Calendar endTime;
    private String text;

    public ReportDTO(WorkerDTO owner, Calendar endTime) {
        this.owner = owner;
        this.startTime = Calendar.getInstance();
        this.endTime = endTime;

    }

    public ReportDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public WorkerDTO getOwner() {
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

<<<<<<< HEAD
    public void setText(String text) {
        this.text = text;
    }

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(WorkerDTO owner) {
        this.owner = owner;
    }

<<<<<<< HEAD
}


=======
//    public void setStartTime(Calendar startTime) {
//        this.startTime = startTime;
//    }
//
//    public void setEndTime(Calendar endTime) {
//        this.endTime = endTime;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

//    public Report convertToDAL() {
//        return new Report(owner.convertToDAL());
//    }
}

>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
