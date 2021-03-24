package BLL;

import BLL.DTO.DayReportDTO;
import BLL.DTO.ReportDTO;
import BLL.DTO.SprintReportDTO;
import BLL.DTO.WorkerDTO;
import BLL.InfoStructure.IReportService;
import DAL.Entities.DayReport;
import DAL.Entities.SprintReport;
import DAL.Entities.Worker;
import DAL.InfoStructure.IReportRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReportService implements IReportService {

    private IReportRepository repo;

    public ReportService(IReportRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addDayReport(DayReportDTO item) {
        var w = new Worker(item.getOwner().getId());
        var dalReport = new DayReport(w);
        repo.addDayReport(dalReport);
        item.setId(dalReport.getId());
    }

    @Override
    public void addSprintReport(SprintReportDTO item) {
        var w = new Worker(item.getOwner().getId());
        var dalSprintReport = new SprintReport(w, item.getEndTime());
        repo.addSprintReport(dalSprintReport);
        item.setId(dalSprintReport.getId());
    }

    @Override
    public List<DayReportDTO> getChildWorkerReport(WorkerDTO item) {
        var w = new Worker(item.getId());
        return repo.getChildWorkerReport(w).stream().
                map(r -> new DayReportDTO(new WorkerDTO(r.getOwner().getId()))).collect(Collectors.toList());
    }

    @Override
    public List<DayReportDTO> getWorkerReport(WorkerDTO worker) {
        var w = new Worker(worker.getId());
        return repo.getWorkerDayReport(w).stream().
                map(r -> new DayReportDTO(new WorkerDTO(r.getOwner().getId()))).collect(Collectors.toList());
    }

    public void saveSprintReport(WorkerDTO worker, SprintReportDTO sprintReport) throws Exception {
        var w = new Worker(worker.getId());
<<<<<<< HEAD
        if(w.getId() != sprintReport.getOwner().getId()) {
=======
        if(w.getChildWorkers() == null) {
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
            throw new Exception("You dont have acces for this action");
        }
        var r = new SprintReport(w, sprintReport.getEndTime());
        repo.saveSprintReport(r);
    }

    public void writeReport(WorkerDTO worker, ReportDTO report, String text) throws Exception {
        var w = new Worker(worker.getId());
        var r = new SprintReport(report.getId());
        repo.writeReport(w, r, text);
<<<<<<< HEAD
        report.setText(r.getText());
    }
}
=======
    }
}
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
