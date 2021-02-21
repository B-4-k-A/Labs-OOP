package BLL.InfoStructure;

import BLL.DTO.DayReportDTO;
import BLL.DTO.SprintReportDTO;
import BLL.DTO.WorkerDTO;

import java.util.Calendar;
import java.util.List;

public interface IReportService {
    void addDayReport(DayReportDTO report);

    void addSprintReport(SprintReportDTO sprintReport);

    List<DayReportDTO> getChildWorkerReport(WorkerDTO worker);

    List<DayReportDTO> getWorkerReport(WorkerDTO worker);

    void saveSprintReport(WorkerDTO worker, SprintReportDTO sprintReport) throws Exception;

}
