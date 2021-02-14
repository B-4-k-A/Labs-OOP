import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import src.*;
import src.cleaner.*;
import src.point.FileInfo;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        try {
            FileInfo vsCode = new FileInfo("vsCode", 100);
            FileInfo vsStudio = new FileInfo("vsStudio", 100);
            FileInfo pyCharm = new FileInfo("pyCharm", 100);
            FileInfo virtualBox = new FileInfo("Virtual box", 100);
            FileInfo SQLserver = new FileInfo("SQLserver", 100);

            Backup backup = new Backup();

            ArrayList<FileInfo> fileInfoList = new ArrayList<>();
            fileInfoList.add(vsCode);
            fileInfoList.add(vsStudio);
            fileInfoList.add(virtualBox);
            fileInfoList.add(SQLserver);
            fileInfoList.add(pyCharm);

            backup.createFullRestoreCopy(fileInfoList);

            fileInfoList.clear();
            fileInfoList.add(vsStudio);
            fileInfoList.add(virtualBox);
            fileInfoList.add(SQLserver);
            fileInfoList.add(pyCharm);
            fileInfoList.add(vsCode);
            vsCode.setSize(200);
            pyCharm.setSize(200);
            SQLserver.setSize(200);

            backup.createIncRestoreCopy(fileInfoList);

            vsCode.setSize(300);
            pyCharm.setSize(300);
            SQLserver.setSize(300);

            sleep(100);
            Date date = new Date();
            backup.createFullRestoreCopy(fileInfoList);
            backup.createFullRestoreCopy(fileInfoList);

            CleanerByDate cleanerByDate = new CleanerByDate(date.getTime());
            CleanerByAmount cleanerByAmount = new CleanerByAmount(2);
            CleanerBySize cleanerBySize = new CleanerBySize(1300);
            List<ICheck> cleaners = Arrays.asList(cleanerByDate, cleanerByAmount, cleanerBySize);
            BaseHybridCleaner cleanerHybridByMin = new CleanerHybridByMax(cleaners);

            backup.showBackupInfo();
            ICheck cleaner = cleanerHybridByMin;
            backup.clean(cleaner);
            System.out.println("***********\n" + "After clean\n" + "***********\n");
            backup.showBackupInfo();


        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}