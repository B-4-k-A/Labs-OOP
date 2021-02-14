package src.cleaner;

import src.point.FileRestoreCopy;
import src.point.IncFileRestoreCopy;

import java.util.ArrayList;
import java.util.List;

public class CleanerByAmount extends BaseCleaner {

    public CleanerByAmount() {
        super();
    }

    public CleanerByAmount(double value) {
        super(value);
    }

    @Override
    public int check(List<FileRestoreCopy> pointsList) {
        List<FileRestoreCopy> tempPoints = new ArrayList<>(pointsList);
        int size = tempPoints.size();
        while(size > value) {
            tempPoints.remove(0);
            size--;
        }
        if(tempPoints.size() == 0) {
            return -1;
        }
        if (tempPoints.get(0) instanceof IncFileRestoreCopy) {
            return -1;
        }
        return tempPoints.size();
    }
}
