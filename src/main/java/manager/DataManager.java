package manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataManager {
    public static String getProperty(String key) {
        Properties properties = new Properties();

        try {
            InputStream in = new FileInputStream("config.xml");
            properties.loadFromXML(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
