import java.util.ArrayList;
import java.util.HashMap;

import src.*;

public class Main {
    public static void main(String[] args) {
        try {
        FileInfo vsCode = new FileInfo("vsCode", 100);
        FileInfo vsStudio = new FileInfo("vsStudio", 300);
        FileInfo pyCharm = new FileInfo("pyCharm", 250);
        FileInfo virtualBox = new FileInfo("Virtual box", 500);
        FileInfo SQLserver = new FileInfo("SQLserver", 600);

        Backup back1 = new Backup();

        ArrayList<FileInfo> fileInfoList = new ArrayList<>();

        fileInfoList.add(vsCode);
        fileInfoList.add(vsStudio);
        fileInfoList.add(virtualBox);
        fileInfoList.add(SQLserver);
        fileInfoList.add(pyCharm);
        back1.createFullRestoreCopy(fileInfoList);
        
        pyCharm.setSize(500);
        SQLserver.setSize(400);
        back1.createIncRestoreCopy(fileInfoList);
        back1.showBackupInfo();


        

        HashMap<String, Double> params = new HashMap<String, Double>();
        params.put("amount", 1d);
        params.put("size", 2000d);
        // params.put("date", (double)date.getTime());
        back1.hybridClean(params, "min");

        back1.showBackupInfo();

        } catch(Exception exp) {
            System.out.println(exp);
        }
    }
}