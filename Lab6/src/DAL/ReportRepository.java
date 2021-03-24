package DAL;

import DAL.Entities.DayReport;
<<<<<<< HEAD
import DAL.Entities.Report;
=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
import DAL.Entities.SprintReport;
import DAL.Entities.Worker;
import DAL.InfoStructure.IReportRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
import java.util.stream.Collectors;

public class ReportRepository implements IReportRepository {

    private List<DayReport> dayReportList = new ArrayList<>();
    private List<SprintReport> sprintReportList = new ArrayList<>();
    public List<SprintReport> savedSprintReportList= new ArrayList<>();



    @Override
    public void addDayReport(DayReport report) {
        report.setId(dayReportList.size() + 1);
        dayReportList.add(report);
    }

    @Override
    public void addSprintReport(SprintReport sprintReport) {
        sprintReport.setId(sprintReportList.size() + 1);
        sprintReportList.add(sprintReport);
    }

    @Override
    public List<DayReport> getChildWorkerReport(Worker worker) {
        List<DayReport> res = new ArrayList<>();
        for(Worker w : worker.getChildWorkers()) {
            List<DayReport> temp = getWorkerDayReport(w);
            if(temp != null) {
                res.addAll(temp);
            }
        }
        return res;
    }

    @Override
    public List<DayReport> getWorkerDayReport(Worker worker) {
        return dayReportList.stream().
                filter(report -> report.getOwner().equals(worker)).
                collect(Collectors.toList());
    }

    @Override
    public void saveSprintReport(SprintReport sprintReport) {
        savedSprintReportList.add(sprintReport);
    }

    @Override
<<<<<<< HEAD
    public void writeReport(Worker worker, SprintReport sprintReport, String text) throws Exception {
        Optional<SprintReport> option = sprintReportList.stream().filter(r -> r.getId() == sprintReport.getId()).
                findFirst();
        if(option.isEmpty()) {
            throw new Exception("SprintReport doesn't exists");
        }
        SprintReport temp = option.get();
        temp.setText(text);
        sprintReport.setText(temp.getText());
    }
}

=======
    public void writeReport(Worker worker, SprintReport sprintReport, String text) {
        sprintReportList.stream().filter(r -> r.getId() == sprintReport.getId()).
                findFirst().get().setText(text);
    }
}
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
