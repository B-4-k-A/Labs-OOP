package src;

import java.util.HashMap;

import javax.naming.NameNotFoundException;

import Exception.TypeConversionException;

public class Data {
    private HashMap<String, HashMap<String, String>> data = new HashMap<>();

    public Data(HashMap<String, HashMap<String, String>> map) {
        data = map;
    }

    private String getValue(String section, String config) throws NameNotFoundException {
        HashMap<String, String> tempSection = new HashMap<>();
        String value;
        if ((tempSection = data.get(section)) == null) {
            throw new NameNotFoundException("There is not this section");
        } else if ((value = tempSection.get(config)) == null) {
            throw new NameNotFoundException("There is not config in " + section);
        }
        return value;
    }

    public int tryGetInt(String section, String config) throws NameNotFoundException {
        String value = getValue(section, config);
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new TypeConversionException(" String \"" + value + "\" cannot be convert to Int");
        }
    }

    public double tryGetDouble(String section, String config) throws NameNotFoundException {
        String value = getValue(section, config);
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new TypeConversionException("String \"" + value + "\" cannot be convert to Double");
        }
    }

    public String tryGetString(String section, String config) throws NameNotFoundException {
        return getValue(section, config);
    }
}
