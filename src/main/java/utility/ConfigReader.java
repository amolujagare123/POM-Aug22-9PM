package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the properties file
        FileInputStream fis = new FileInputStream("config/config.properties");

        // 2. create the object of Properties
        Properties prop = new Properties();

        // 3. load the file object with properties object
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }

    public static String getUsername() throws IOException {
        return getLoadedPropertiesObject().getProperty("username");
    }

    public static String getPassword() throws IOException {
        return getLoadedPropertiesObject().getProperty("password");
    }
}
