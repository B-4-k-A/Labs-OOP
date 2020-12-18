package src;

import java.util.ArrayList;
import java.util.Date;

public class FullFileRestoreCopy extends FileRestoreCopy {

    public FullFileRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        createRestoreCopy(fileInfoList);
    }

    @Override
    void createRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        for (FileInfo fileInfo : fileInfoList) {
            addFile(new FileInfo(fileInfo));
            incrementSize(fileInfo.getSize());
        }
        setData(new Date());
    }
}
