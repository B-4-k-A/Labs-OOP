package DAL;

import DAL.Entities.DayReport;
import DAL.Entities.SprintReport;
import DAL.Entities.Worker;
import DAL.InfoStructure.IReportRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    public void writeReport(Worker worker, SprintReport sprintReport, String text) {
        sprintReportList.stream().filter(r -> r.getId() == sprintReport.getId()).
                findFirst().get().setText(text);
    }
}
