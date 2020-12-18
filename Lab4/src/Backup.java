package src;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.Date;
import java.util.HashMap;

public class Backup {

    private ArrayList<FileRestoreCopy> pointList = new ArrayList<>();

    private double size = 0;

    private String id;

    private Date date;

    public Backup() {
        this.date = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public double getSize() {
        return this.size;
    }

    public String getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void createFullRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        var point = new FullFileRestoreCopy(fileInfoList);
        this.size += point.getSize();
        pointList.add(point);
    }

    public void createIncRestoreCopy(ArrayList<FileInfo> fileInfoList) throws Exception {
        if (pointList.size() == 0) {
            throw new Exception("Increment restore copy can not be created before full point restore copy");
        }
        int sizeOfList = pointList.size() - 1;
        for (FileInfo file : fileInfoList) {
            boolean notFound = true;
            for (int i = sizeOfList; i >= 0; i--) {
                String[] infoLinesOfFiles = pointList.get(i).showFilesInPoint();
                for (String infoLine : infoLinesOfFiles) {
                    if (!(infoLine.indexOf(file.getName()) == -1)) {
                        notFound = false;
                        break;
                    }
                }
            }
            if (notFound) {
                throw new Exception("File " + file.getName() + " doesn't have full restore copy,"
                        + "so it can not have increment restore copy");
            }
        }
        var point = new IncFileRestoreCopy(fileInfoList, pointList.get(sizeOfList));
        this.size += point.getSize();
        pointList.add(point);
    }

    public void saveBackupToArchive(String path) {
        System.out.println("Backup saved in archive:");
        System.out.println("\tPath\tSize");
        System.out.printf("%s\t%d\t", path, size);
    }

    public void saveBackupInPath(String path) {
        System.out.println("Points saved in:" + path);
        for (var point : pointList) {
            System.out.println("\tPoint by" + new Date(point.getDate().getTime()));
            System.out.println("\t\tName\tSize");
            System.out.println("\t\t" + point.showFilesInPoint());
        }
    }

    public void showBackupInfo() {
        System.out.println("ID\t\t\t\t\tDate\t\t\t\tSize");
        System.out.println(getId() + "\t" + new Date(getDate().getTime()) + "\t" + getSize());
        for (int i = 0; i < pointList.size(); i++) {
            System.out.println("\tNumber\tDate");
            FileRestoreCopy currPoint = pointList.get(i);
            System.out.println("\t" + (i + 1) + "-" + currPoint.getClass().toString().substring(10) + " point:\t"
                    + new Date(currPoint.getDate().getTime()));
            for (String infoLine : currPoint.showFilesInPoint()) {
                System.out.println("\t\t" + infoLine);
            }

        }

    }

    public int checkByAmount(double amount) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointList);
        for (int i = tempPoints.size() - 1; i > amount; i--) {
            tempPoints.remove(0);
        }
        if (tempPoints.get(0) instanceof IncFileRestoreCopy) {
            return -1;
        }
        return tempPoints.size();
    }

    public void cleanByAmount(double amount) throws Exception {
        if (checkByAmount(amount) > -1) {
            for (int i = pointList.size() - 1; i > amount; i--) {
                pointList.remove(0);
            }
        } else {
            throw new Exception("Backup can not clean by " + amount + " last points");
        }
    }

    public int checkByDate(long date) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointList);
        for (int i = tempPoints.size() - 1; i > 0; i--) {
            if (tempPoints.get(i).getDate().getTime() > date) {
                tempPoints.remove(0);
            }
        }
        if (tempPoints.get(0) instanceof IncFileRestoreCopy) {
            return -1;
        }
        return tempPoints.size();
    }

    public void cleanByDate(long date) throws Exception {
        if (checkByDate(date) > -1) {
            for (int i = 0; i < pointList.size(); i++) {
                pointList.remove(i);
            }
        } else {
            throw new Exception("Backup can not clean by " + new Date(date) + " date");
        }
    }

    public int checkBySize(double size) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointList);
        double currenSize = this.size;
        while (currenSize > size) {
            currenSize -= tempPoints.get(0).getSize();
            tempPoints.remove(0);
        }
        if (tempPoints.get(0) instanceof IncFileRestoreCopy) {
            return -1;
        }
        return tempPoints.size();
    }

    public void cleanBySize(double size) throws Exception {
        if (checkBySize(size) > -1) {
            while (getSize() > size) {
                this.size -= pointList.get(0).getSize();
                pointList.remove(0);
            }
        } else {
            throw new Exception("Backup can not clean by " + size + " size");
        }
    }

    public void hybridClean(HashMap<String, Double> params, String mode) throws Exception {

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (Entry<String, Double> param : params.entrySet()) {
            if (param.getKey().equalsIgnoreCase("amount")) {
                int num;
                if ((num = checkByAmount(param.getValue())) > -1) {
                    if (num < min) {
                        min = num;
                    } else if (num > max) {
                        max = num;
                    }
                }

            } else if (param.getKey().equalsIgnoreCase("date")) {
                int num;
                if ((num = checkByDate(param.getValue().longValue())) > -1) {
                    if (num < min) {
                        min = num;
                    } else if (num > max) {
                        max = num;
                    }
                }
            } else if (param.getKey().equalsIgnoreCase("size")) {
                int num;
                if ((num = checkBySize(param.getValue())) > -1) {
                    if (num < min) {
                        min = num;
                    } else if (num > max) {
                        max = num;
                    }
                }
            } else {
                throw new Exception("Incorrect parameters of hybrid clean.");
            }
        }

        if (mode.equalsIgnoreCase("minimum")) {

            for (int i = pointList.size() - min - 1; i >= 0; i--) {
                pointList.remove(0);
            }

        } else if (mode.equalsIgnoreCase("maximum")) {

            for (int i = pointList.size() - max - 1; i >= 0; i--) {
                pointList.remove(0);
            }

        } else {
            throw new Exception("Unknown mode of hybrid clean.");
        }
    }
}
