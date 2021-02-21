package src.cleaner;

import src.point.FileRestoreCopy;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerHybridByMin extends BaseHybridCleaner{


    public CleanerHybridByMin(List<ICheck> checker) {
        super(checker);
    }
    @Override
    public int check(List<FileRestoreCopy> pointsList) {
        List<Integer> values = getCounts(pointsList);
        values.sort((x,y) -> {
            if(x > y) { return 1; }
            if(x == y) { return 0; }
            return -1;
        });
        return values.get(0);
    }
}
