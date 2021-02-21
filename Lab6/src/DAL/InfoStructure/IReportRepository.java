package DAL.InfoStructure;

import DAL.Entities.DayReport;
import DAL.Entities.SprintReport;
import DAL.Entities.Worker;

import java.util.Calendar;
import java.util.List;

public interface IReportRepository {
    void addDayReport(DayReport report);

    void addSprintReport(SprintReport sprintReport);

    List<DayReport> getChildWorkerReport(Worker worker);

    List<DayReport> getWorkerDayReport(Worker worker);

    void saveSprintReport(SprintReport sprintReport);

    void writeReport(Worker worker, SprintReport sprintReport, String text);
}
