package configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/configs.properties";

    public String getProperty(String setProperty) {
        try {
            FileInputStream fileInputStream;
            Properties prop = new Properties();
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            String property = prop.getProperty(setProperty);
            return property;
        } catch (IOException e) {
            System.out.println("configs.property file can't be read");
        }
            return setProperty;
    }
}
