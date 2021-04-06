import java.io.File;

public class Main {
    public static void main(String[] args) {

        String configFileName = null;

        if(args.length == 0 || args[0].equals("production")) configFileName = "config.txt";
        else if(args[0].equalsIgnoreCase("development")) configFileName = "config.txt.dev";
        else if(args[0].equalsIgnoreCase("staging")) configFileName = "config.txt.staging";
        else System.out.println("Invalid Argument");


        assert configFileName != null;
        ConfigParser config = new ConfigParser(new File(configFileName));
        System.out.println(config.get("application.name"));


    }
}
