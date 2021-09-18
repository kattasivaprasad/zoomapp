package helpers;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class PropertyLoader {

    private static CompositeConfiguration config;

    public PropertyLoader() {
        try {
            config = new CompositeConfiguration();
            config.addConfiguration(new SystemConfiguration());
            config.addConfiguration(new PropertiesConfiguration("src/test/resources/config.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return config.getString(key);
    }

}
