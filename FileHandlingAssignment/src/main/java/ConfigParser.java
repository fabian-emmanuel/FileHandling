import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigParser {

    //configParser method that reads the file, stores the key and value in a LinkedHashMap and returns a map
    public Map<String, String> configParser(String filePath) {
        Map<String, String> configFile = new LinkedHashMap<>();
        String line;
        String[] strData;

        //The file will be read by the BufferedReader method
        try(FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null ) {
                if (line.contains("=")) {
                    strData = line.split("=");
                    if (strData.length > 1) {
                        if ((strData[0].equals("name")) || (strData[0].equals("port")) || (strData[0].equals("context-url"))) {
                            strData[0] = "application." + strData[0];
                        }
                    }
                    configFile.putIfAbsent(strData[0], strData[1]);
                }
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return configFile;
        }
    }

