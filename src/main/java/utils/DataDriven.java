package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class DataDriven {
    public static JsonNode jsonReader() {
        try (InputStream stream = DataDriven.class.getClassLoader()
                .getResourceAsStream("testData.json")) {
            if (stream == null) {
                throw new IllegalStateException("testData.json not found on classpath");
            }
            return new ObjectMapper().readTree(stream);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read testData.json", e);
        }
    }
}
