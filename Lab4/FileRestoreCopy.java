package src.point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FileRestoreCopy {
    protected List<FileInfo> fileList = new ArrayList<>();
    protected double size = 0;
    protected Date date;

    protected abstract void createRestoreCopy(ArrayList<FileInfo> listOfFile);

    protected void addFile(FileInfo fileInfo) {
        fileList.add(fileInfo);
    }

    public Date getDate() {
        return this.date;
    }

    public double getSize() {
        return this.size;
    }

    public List<String> getListOfFiles() {
        return fileList.stream().map(o -> o.toString()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().toString().substring(10) + " point:\t"
                + new Date(date.getTime()));
        for(String infoLine : getListOfFiles()) {
            str.append("\n" + infoLine);
        }
        str.append("\n");
        return str.toString();
    }
}
