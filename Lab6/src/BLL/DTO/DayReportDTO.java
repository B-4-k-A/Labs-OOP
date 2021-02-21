package BLL.DTO;

import java.util.Calendar;

public class DayReportDTO extends ReportDTO {
    public DayReportDTO(WorkerDTO owner) {
        super(owner, null);
    }

    public DayReportDTO(int id) {
        super(id);
    }
}
