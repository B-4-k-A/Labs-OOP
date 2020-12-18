package src;

import java.util.ArrayList;
import java.util.Date;

public abstract class FileRestoreCopy {
    protected ArrayList<FileInfo> fileList = new ArrayList<>();
    private double size = 0;
    private Date date;

    abstract void createRestoreCopy(ArrayList<FileInfo> listOfFile);

    protected void addFile(FileInfo fileInfo) {
        fileList.add(fileInfo);
    }

    protected void setData(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public double getSize() {
        return this.size;
    }

    protected void incrementSize(double size) {
        this.size += size;
    }

    public String[] showFilesInPoint() {
        int sizeOfList = fileList.size();
        String[] info = new String[sizeOfList];
        for(int i = 0; i < sizeOfList; i++) {
            FileInfo fileInfo = fileList.get(i);
            info[i] = fileInfo.getName() + "\t" + fileInfo.getSize();
        }
        return info;
    }

}
