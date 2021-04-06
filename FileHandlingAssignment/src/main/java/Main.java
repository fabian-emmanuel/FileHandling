public class Main {
    public static void main(String[] args) {

        String filePath = null;

        if(args.length == 0 || args[0].equals("production")) filePath = "src/main/resources/config.txt";
        else if(args[0].equalsIgnoreCase("development")) filePath = "src/main/resources/config.txt.dev";
        else if(args[0].equalsIgnoreCase("staging")) filePath = "src/main/resources/config.txt.staging";
        else System.out.println("Invalid Argument");

        assert filePath != null;
        ConfigParser config = new ConfigParser();
        String valueOf = config.configParser(filePath).get("application.mode");
        System.out.println(valueOf);
    }
}
