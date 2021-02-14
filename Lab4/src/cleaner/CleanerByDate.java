package src.cleaner;

import src.Backup;
import src.point.FileRestoreCopy;
import src.point.IncFileRestoreCopy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CleanerByDate extends BaseCleaner {

    public CleanerByDate() {
    }

    public CleanerByDate(double value) {
        super(value);
    }

    @Override
    public int check(List<FileRestoreCopy> pointsList) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointsList);
//        for(FileRestoreCopy point : backup.pointsList)
        for (int i = tempPoints.size() - 1; i >= 0 ;i--) {
            if (tempPoints.get(i).getDate().getTime() < (long) value) {
                tempPoints.remove(0);
            }
        }
        if(tempPoints.size() == 0) {
            return -1;
        }
        if (tempPoints.get(0) instanceof IncFileRestoreCopy) {
            return -1;
        }
        return tempPoints.size();
    }

//    @Override
//    public void clean(List<FileRestoreCopy> pointsList) throws Exception {
//       int count = check(pointsList);
//        if (count > -1) {
//            while(count < pointsList.size()) {
//                pointsList.remove(0);
//            }
//        } else {
//            throw new Exception("Backup can not clean by " + new Date((long)value) + " date");
//        }
//    }
}
