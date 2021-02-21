package UI.ViewModel;

import DAL.Entities.Report;
import DAL.Entities.Worker;

import java.util.Calendar;

public class SprintReportView extends ReportView {

    private String draft;

    public SprintReportView(WorkerView owner, Calendar endTime) {
        super(owner, endTime);
    }

    public SprintReportView(int id) {
       super(id);
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft= draft;
    }

}
