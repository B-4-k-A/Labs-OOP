package src.cleaner;

import src.point.FileRestoreCopy;

import java.util.List;

public class Clean implements IClean{

    @Override
    public void clean(List<FileRestoreCopy> pointsList, ICheck checker) throws Exception {
        int count = checker.check(pointsList);
        if(count == -1) {
            throw new Exception("Backup cannot be cleaned by " +
                    checker.getClass().toString().substring(18) + " with current value");
        }
        int size = pointsList.size();
        while(size > count) {
            pointsList.remove(0);
            size--;
        }

    }

}
