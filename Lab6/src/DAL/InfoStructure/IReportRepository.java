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

<<<<<<< HEAD
    void writeReport(Worker worker, SprintReport sprintReport, String text) throws Exception;
}

=======
    void writeReport(Worker worker, SprintReport sprintReport, String text);
}
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
