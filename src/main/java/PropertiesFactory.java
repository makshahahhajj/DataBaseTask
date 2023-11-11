import java.io.IOException;
import java.io.InputStream;

public final class PropertiesFactory {

    private static DatabaseProperties properties;
    
    private PropertiesFactory() {
        
    }

    public static synchronized DatabaseProperties getProperties() {
        if (properties == null) {
            init();
        }

        return properties;
    }

    

    private static void init() {
        String filePropertyName = "application.properties";

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        properties = new DatabaseProperties();

        try (InputStream stream = classLoader.getResourceAsStream(filePropertyName)) {
            properties.load(stream);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());

            System.exit(-1);
        }
    }
    
}