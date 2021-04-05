package org.codewithfabian;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String myKey = "application.name";
        try {
            String fileName = args[0];
            String filePathName = null;

            if (fileName.equalsIgnoreCase("Production")) filePathName = "config.txt";
            else if (fileName.equalsIgnoreCase("Development")) filePathName = "config.txt.dev";
            else if (fileName.equalsIgnoreCase("Staging")) filePathName = "config.txt.staging";
            else System.out.println("Invalid argument!");

            assert filePathName != null;
            File configFile = new File(filePathName);
            ConfigParser config = new ConfigParser(configFile);
            System.out.println(config.get(myKey));

        } catch (ArrayIndexOutOfBoundsException a){
            File configFile = new File("config.txt");
            ConfigParser config = new ConfigParser(configFile);
            System.out.println(config.get(myKey));
        }
    }
}