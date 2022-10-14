package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigProvider {

    Properties properties;

    public void configProvider(String fileName) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        properties = new Properties();
        properties.load(is);
    }
}
