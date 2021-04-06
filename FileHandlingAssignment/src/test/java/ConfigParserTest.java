import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigParserTest {

    @Test
    void getTest() {
        String configFileName = "config.txt";
        ConfigParser config = new ConfigParser(new File(configFileName));
        String expected = "production";
        assertEquals(expected, config.get("application.mode"));
    }
}