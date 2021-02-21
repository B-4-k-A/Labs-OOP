package BLL.DTO;

import DAL.Entities.SprintReport;

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

//    @Override
//    public SprintReport convertToDAL() {
//        var sprintReport = (SprintReport)super.convertToDAL();
//        sprintReport.setDraft(draft);
//        return sprintReport;
//    }
}
