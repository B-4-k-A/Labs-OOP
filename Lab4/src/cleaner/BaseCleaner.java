package src.cleaner;

import src.Backup;
import src.point.FileRestoreCopy;

import java.util.List;

public abstract class BaseCleaner extends Clean implements ICheck{
    protected double value;

    protected BaseCleaner() {}

    protected BaseCleaner(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
