import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigParser {
    private final String filePath;
    private final Map<String, String> configFile;

    //ConfigParser constructor - takes a string filename
    public ConfigParser(File file) {
        this.filePath = "src/main/resources/" + file;
        configFile = new LinkedHashMap<>();
    }

    //ParseFile method
    public void parseConfigFile() {
        String line;
        String[] strData;
        //The file will be read by the BufferedReader method
        try(FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null ) {
                if (line.contains("=")) {
                    strData = line.split("=");
                    if (strData.length > 1) {
                        if (!(strData[0].equals("dbname")) && !(strData[0].equals("host"))) {
                            strData[0] = "application." + strData[0];
                        }
                    }
                    configFile.putIfAbsent(strData[0], strData[1]);
                }
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    //the get Method first calls the parseConfigFile method then uses the map entry to get the values for a key passed
    public String get(String key){
        this.parseConfigFile();
        String value = null;
        for(Map.Entry<String, String> item: configFile.entrySet()){
            if(item.getKey().equals(key)) value = item.getValue();
        }
        return value;
    }
}
