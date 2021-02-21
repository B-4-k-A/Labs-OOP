package src;

import src.cleaner.Clean;
import src.cleaner.ICheck;
import src.point.*;

import java.util.*;

public class Backup{

    private List<FileRestoreCopy> pointsList = new ArrayList<>();

    private double size = 0;

    private String id;

    private Date date;

    public Backup() {
        this.date = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void createFullRestoreCopy(ArrayList<FileInfo> fileInfoList) {
        var fullPoint = new FullFileRestoreCopy(fileInfoList);
        this.size += fullPoint.getSize();
        pointsList.add(fullPoint);
    }

    public void createIncRestoreCopy(ArrayList<FileInfo> fileInfoList) throws Exception {
        if (pointsList.size() == 0) {
            throw new Exception("Increment restore copy can not be created before full point restore copy");
        }
        int sizeOfList = pointsList.size() - 1;
        for (FileInfo newFileInfo : fileInfoList) {
            boolean found = false;
            for (int i = sizeOfList; i >= 0; i--) {
                List<String> infoLines = pointsList.get(i).getListOfFiles();
                for (String infoLine : infoLines) {
                    if (!(infoLine.indexOf(newFileInfo.getName()) == -1)) {
                        found = true;
                        break;
                    }
                }
                if(found) {
                   break;
                }
            }
            if (!found) {
                throw new Exception("File " + newFileInfo.getName() + " doesn't have full restore copy,"
                        + "so it can not have increment restore copy");
            }
        }
        var point = new IncFileRestoreCopy(fileInfoList, pointsList.get(sizeOfList));
        if(point.getSize() == 0) {
            throw new Exception("Inc point restore copy cannot be created because files in List is not changed");
        }
        this.size += point.getSize();
        pointsList.add(point);
    }

    public void saveToArchive(String path) {
        System.out.println("Backup saved in archive:");
        System.out.println("\tPath\tSize");
        System.out.print( path + "\t" + size);
    }

    public void saveInPath(String path) {
        System.out.println("Points saved in:" + path);
        for (var point : pointsList) {
            System.out.println("\tPoint by" + new Date(point.getDate().getTime()));
            System.out.println("\t\tName\tSize");
            System.out.println("\t\t" + point);
        }
    }

    public void showBackupInfo() {
        System.out.println("ID\t\t\t\t\t\t\t\t\t\tDate\t\t\t\t\t\t\tSize");
        System.out.println(id + "\t" + new Date(getDate().getTime()) + "\t" + size);
        int i = 1;
        for(FileRestoreCopy point : pointsList) {
            System.out.println(i + ". " + point);
            i++;
       }
   }

    public int checkByAmount(double amount) {
        ArrayList<FileRestoreCopy> tempPoints = new ArrayList<>(pointsList);
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
            for (int i = pointsList.size() - 1; i > amount; i--) {
                pointsList.remove(0);
            }
        } else {
            throw new Exception("Backup can not clean by " + amount + " last points");
        }
    }

    public void clean(ICheck checker) throws Exception {
        Clean clean = new Clean();
        clean.clean(pointsList, checker);
       size = size();
    }

    public double size() {
        double size = 0;
        for(FileRestoreCopy point : pointsList) {
            size += point.getSize();
        }
        return size;
    }

//    public int checkByDate(long date) {
//
//    }
//
//    public void cleanByDate(long date) throws Exception {
//
//    }

//    public int checkBySize(double size) {
//
//    }

//    public void cleanBySize(double size) throws Exception {
//
//    }

//    public void hybridClean(HashMap<String, Double> params, String mode) throws Exception {
//
//        int max = 0;
//        int min = Integer.MAX_VALUE;
//        for (Entry<String, Double> param : params.entrySet()) {
//            if (param.getKey().equalsIgnoreCase("amount")) {
//                int num;
//                if ((num = checkByAmount(param.getValue())) > -1) {
//                    if (num < min) {
//                        min = num;
//                    } else if (num > max) {
//                        max = num;
//                    }
//                }
//
//            } else if (param.getKey().equalsIgnoreCase("date")) {
//                int num;
//                if ((num = checkByDate(param.getValue().longValue())) > -1) {
//                    if (num < min) {
//                        min = num;
//                    } else if (num > max) {
//                        max = num;
//                    }
//                }
//            } else if (param.getKey().equalsIgnoreCase("size")) {
//                int num;
//                if ((num = checkBySize(param.getValue())) > -1) {
//                    if (num < min) {
//                        min = num;
//                    } else if (num > max) {
//                        max = num;
//                    }
//                }
//            } else {
//                throw new Exception("Incorrect parameters of hybrid clean.");
//            }
//        }
//
//        if (mode.equalsIgnoreCase("minimum")) {
//
//            for (int i = pointsList.size() - min - 1; i >= 0; i--) {
//                pointsList.remove(0);
//            }
//
//        } else if (mode.equalsIgnoreCase("maximum")) {
//
//            for (int i = pointsList.size() - max - 1; i >= 0; i--) {
//                pointsList.remove(0);
//            }
//
//        } else {
//            throw new Exception("Unknown mode of hybrid clean.");
//        }
//    }
}
