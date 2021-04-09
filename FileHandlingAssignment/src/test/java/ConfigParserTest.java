import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigParserTest {

    @Test
    void getTest() {
        String filePath = "/Users/decagon/FileHandlingAssignment/src/main/resources/config.txt";
        ConfigParser config = new ConfigParser();
        String expected = "production";
        assertEquals(expected, config.configParser(filePath).get("mode"));
    }
        @Test
        void getTest2 () {
            String filePath2 = "/Users/decagon/FileHandlingAssignment/src/main/resources/config.txt.dev";
            ConfigParser config2 = new ConfigParser();
            String expected2 = "development";
            assertEquals(expected2, config2.configParser(filePath2).get("mode"));
        }
        @Test
        void getTest3(){

        String filePath3 = "/Users/decagon/FileHandlingAssignment/src/main/resources/config.txt.staging";
        ConfigParser config3 = new ConfigParser();
        String expected3 = "staging";
        assertEquals(expected3, config3.configParser(filePath3).get("mode"));
    }
}