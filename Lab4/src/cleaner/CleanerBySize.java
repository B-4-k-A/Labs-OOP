package src.cleaner;

import src.Backup;
import src.point.FileRestoreCopy;
import src.point.IncFileRestoreCopy;

import java.util.ArrayList;
import java.util.List;

public class CleanerBySize extends BaseCleaner{

    protected CleanerBySize() {
        super();
    }

    public CleanerBySize(double value) {
        super(value);
    }

    private double sizeOfBackup(List<FileRestoreCopy> pointsList) {
        double size = 0;
        for(FileRestoreCopy point : pointsList) {
            size += point.getSize();
        }
        return size;
    }

    @Override
    public int check(List<FileRestoreCopy> pointsList) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointsList);
        double currenSize = sizeOfBackup(pointsList);
        while (currenSize > value) {
            currenSize -= tempPoints.get(0).getSize();
            tempPoints.remove(0);
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
//        if (check(pointsList) > -1) {
//            double size = sizeOfBackup(pointsList);
//            while (size > value) {
//                size -= pointsList.get(0).getSize();
//                pointsList.remove(0);
//            }
//        } else {
//            throw new Exception("Backup can not clean by " + value + " size");
//        }
//    }
}
