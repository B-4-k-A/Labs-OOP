package BLL.DTO;

<<<<<<< HEAD
=======
import DAL.Entities.SprintReport;
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af

import java.util.Calendar;

public class SprintReportDTO extends ReportDTO {

    private String draft;

    public SprintReportDTO(WorkerDTO owner, Calendar endTime) {
        super(owner, endTime);
    }

    public SprintReportDTO(int id) {
        super(id);
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft= draft;
    }

<<<<<<< HEAD
}

=======
//    @Override
//    public SprintReport convertToDAL() {
//        var sprintReport = (SprintReport)super.convertToDAL();
//        sprintReport.setDraft(draft);
//        return sprintReport;
//    }
}
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
