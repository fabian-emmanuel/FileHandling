import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigParserTest {

    @Test
    void getTest() {
        String filePath = "src/main/resources/config.txt/";
        ConfigParser config = new ConfigParser();
        String expected = "production";
        assertEquals(expected, config.configParser(filePath).get("application.name"));
    }
}