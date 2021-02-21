package src.point;

import java.util.ArrayList;
import java.util.Date;

public class IncFileRestoreCopy extends FileRestoreCopy {

    private FileRestoreCopy prevRestorePoint;

    public IncFileRestoreCopy(ArrayList<FileInfo> fileInfoList, FileRestoreCopy prevRestorePoint) {
        this.prevRestorePoint = prevRestorePoint;
        createRestoreCopy(fileInfoList);
        date = new Date();
    }

    @Override
    protected void createRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        for (FileInfo newFileInfo : fileInfoList) {
            boolean notFound = true;
            for(FileInfo pastFileInfo : prevRestorePoint.fileList) {
                if(newFileInfo.getName().equals(pastFileInfo.getName())) {
                    double size = Math.abs(newFileInfo.getSize() - pastFileInfo.getSize());
                    if(size == 0) {
                        notFound = false;
                        break;
                    }
                    this.size += size;
                    addFile(new FileInfo(newFileInfo.getName(), size));
                    notFound = false;
                    break;
                } 
            }
            if(notFound) {
                this.size += newFileInfo.getSize();
                addFile(newFileInfo);
            }
        }
    }

    public FileRestoreCopy getPrevPoint() {
        return prevRestorePoint;
    }

}
