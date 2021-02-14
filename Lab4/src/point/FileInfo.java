package src.point;


public class FileInfo {
    private String name;
    private double size;

    public FileInfo(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public FileInfo(FileInfo fileInfo) {
        this.name = fileInfo.getName();
        this.size = fileInfo.getSize();
    }

    public String getName() {
        return this.name;
    }

    public double getSize() {
        return this.size;
    }
        
    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "\t\t" + size ;
    }
}
