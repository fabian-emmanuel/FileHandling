public class Main {
    public static void main(String[] args) {

        String filePath = null;

        if(args.length == 0 || args[0].equals("production")) filePath = "src/main/resources/config.txt";
        else if(args[0].equalsIgnoreCase("development")) filePath = "src/main/resources/config.txt.dev";
        else if(args[0].equalsIgnoreCase("staging")) filePath = "src/main/resources/config.txt.staging";
        else System.out.println("Invalid Argument");

        assert filePath != null;
        ConfigParser config = new ConfigParser();

        String valueOfDbname = config.configParser(filePath).get("dbname");
        String valueOfHost = config.configParser(filePath).get("host");
        String valueOfMode = config.configParser(filePath).get("mode");
        String valueOfTheme = config.configParser(filePath).get("theme");
        String valueOfPipeline = config.configParser(filePath).get("pipeline");
        System.out.println(valueOfDbname + " ** " + valueOfHost + " ** " + valueOfMode + " ** " + valueOfTheme + " ** " + valueOfPipeline );


        String valueOfName = config.configParser(filePath).get("application.name");
        String valueOfPort = config.configParser(filePath).get("application.port");
        String valueOfContextUrl = config.configParser(filePath).get("application.context-url");
        System.out.println(valueOfName + " ** " + valueOfPort + " ** " + valueOfContextUrl);
    }
}
