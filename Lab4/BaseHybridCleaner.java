package src.cleaner;

import src.point.FileRestoreCopy;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHybridCleaner extends Clean implements ICheck{

    protected List<ICheck> checkers = new ArrayList<>();

    public BaseHybridCleaner(List<ICheck> checker) {
        this.checkers = checker;
    }

    protected List<Integer> getCounts(List<FileRestoreCopy> pointsList) {
        List<Integer> values = new ArrayList<>();
        for(ICheck checker : checkers) {
            values.add(checker.check(pointsList));
        }
        return values;
    }


}
