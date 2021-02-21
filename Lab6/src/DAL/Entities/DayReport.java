package DAL.Entities;

import java.util.Calendar;

public class DayReport extends Report{
    public DayReport(Worker owner) {
        super(owner, null);
    }

    public DayReport(int id) {
        super(id);
    }
}
