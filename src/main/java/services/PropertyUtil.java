package services;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyUtil{

    public static final Properties TEST_PROPERTIES = getProperties("test.properties");

    @SneakyThrows
    private static Properties getProperties(String propertyFilePath) {
        Properties properties = new Properties();
        properties.load(services.PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath));
        return properties;
    }

}
