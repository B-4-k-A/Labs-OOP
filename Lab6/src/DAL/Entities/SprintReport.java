package DAL.Entities;

import java.util.Calendar;

public class SprintReport extends Report{

    private String draft;

    public SprintReport(Worker owner, Calendar endTime) {
        super(owner, endTime);
    }

    public SprintReport(int id) {
        super(id);
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft= draft;
    }

}
