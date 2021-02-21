package src.point;

import java.util.ArrayList;
import java.util.Date;

public class FullFileRestoreCopy extends FileRestoreCopy {

    public FullFileRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        createRestoreCopy(fileInfoList);
    }

    @Override
    protected void createRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        for (FileInfo fileInfo : fileInfoList) {
            addFile(new FileInfo(fileInfo));
            size += fileInfo.getSize();
        }
        date = new Date();
    }
}
