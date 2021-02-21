package src.cleaner;

import src.point.FileRestoreCopy;

import java.util.List;

public interface IClean {

    public void clean(List<FileRestoreCopy> pointsList, ICheck checker) throws Exception;
}
