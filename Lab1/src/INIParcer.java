package src;

import java.io.*;
import java.util.*;

import Exception.*;

public class INIParcer {

    private static String deleteCom(String line) {
        int i = line.indexOf(";");
        if (i != -1) {
            return line.replaceAll(line.substring(i), "");
        }
        return line;
    }

    private static HashMap<String, HashMap<String, String>> read(File file)
            throws FileFormatException, WrongFileExtensionException, FileNotFoundException {
        HashMap<String, HashMap<String, String>> data = new HashMap<>();
        if (!file.getName().matches("[a-zA-Z0-9_]*\\.ini")) {
            throw new WrongFileExtensionException("Error! Wrong extension of file.");
        }
        Scanner scan = new Scanner(file);
        String line;
        String curSection = "";
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            line = (deleteCom(line)).replaceAll(" ", "");
            if (line.isBlank()) {
                continue;
            } else {
                if (line.matches("\\[[a-zA-Z0-9_]*]")) {
                    curSection = line.substring(1, line.length() - 1);
                    data.put(curSection, new HashMap<String, String>());
                } else if (line.matches("[a-zA-Z0-9_]*?[=]?[a-zA-Z0-9./]*") && (curSection != "")) {
                    String[] words = line.split("=");
                    data.get(curSection).put(words[0], words[1]);
                } else {
                    throw new FileFormatException("Error! Wrong file format.");
                }

            }

        }
        scan.close();
        return data;
    }

    public static Data getData(File file)
            throws FileNotFoundException, FileFormatException, WrongFileExtensionException {
        return new Data(read(file));
    }

}