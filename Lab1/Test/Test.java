package Test;


import java.io.*;

import Exception.FileFormatException;
import Exception.WrongFileExtensionException;
import src.*;

public class Test {
    Data data;

    public Test(File file) throws FileNotFoundException, FileFormatException, WrongFileExtensionException {
        data = INIParcer.getData(file);
    }


}
