package UI.ViewModel;

import DAL.Entities.Report;
import DAL.Entities.Worker;

public class DayReportView extends ReportView {
    public DayReportView(WorkerView owner) {
        super(owner, null);
    }

    public DayReportView(int id) {
        super(id);
    }
}
