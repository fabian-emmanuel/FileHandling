package org.codewithfabian;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConfigParser {
    private final Map<String, String> readFile;
    private final String filePath;
    Scanner scReader;

    public ConfigParser(File configFilename){
        readFile = new LinkedHashMap<>();
        this.filePath = "src/main/java/resources/"+configFilename;
    }

    private void parseConfigFile() {
        try {
            FileReader reader = new FileReader(filePath);
            scReader = new Scanner(reader);
            while(scReader.hasNextLine()){
                String data = scReader.nextLine();

                if(data.contains("=")){
                    int counter = 0;
                    String[] arrStr = data.split("=");
                    String key = arrStr[0];
                    String value = arrStr[1];
                    if(readFile.size() != 0){
                        for(Map.Entry<String, String> items: readFile.entrySet()){
                            if(key.equals("name")) key = "application.name";
                            if(items.getKey().equals(key)) counter++;
                        }
                    }

                    if(counter == 0){
                        String name = "name";
                        if(key.equals(name)) readFile.put("application.name", value);
                        else readFile.put(key, value);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scReader.close();
        }
    }

    public String get(String key){
        this.parseConfigFile();
        String value = null;

        for(Map.Entry<String, String> item: readFile.entrySet()){
            if(item.getKey().equals(key)) value = item.getValue();
        }
        return value;
    }

}
