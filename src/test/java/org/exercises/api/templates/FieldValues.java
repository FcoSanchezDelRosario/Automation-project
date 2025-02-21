package org.exercises.api.templates;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.Properties;

import static java.util.stream.Collectors.toMap;

public class FieldValues {

    @SneakyThrows
    public static Map<String, String> in(String propertiesFile) {
        Properties properties = new Properties();
        properties.load(FieldValues.class.getResourceAsStream("/" + propertiesFile));
        return properties.entrySet()
                .stream()
                .collect(toMap(entry -> entry.getKey().toString(),
                        entry -> entry.getValue().toString()));
    }
}
