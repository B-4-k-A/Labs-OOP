package src;

import java.io.*;

public class Main {
    public static void main(String[] arg) {
        try{
            Data data = INIParcer.getData(new File("input.ini"));
            int LogXML = data.tryGetInt("COMMON", "LogXML");
            double SampleRate = data.tryGetDouble("ADC_DEV", "SampleRate");
            int EnableChannelControl = data.tryGetInt("ADC_DEV", "Driver");

            System.out.println(LogXML);
            System.out.println(SampleRate);
            System.out.println(EnableChannelControl);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
