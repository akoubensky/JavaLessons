package org.myproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String JSON_STRING = "{" +
                "\"field1\": \"value1\"," +
                "\"field2\": 25," +
                "\"field3\": [1,2,3]" +
            "}";

    static void writeCarTest() throws IOException {
        CarsList cars = new CarsList();
        cars.setCars(List.of(
                Car.builder().type("Renault").color("Yellow").build(),
                Car.builder().type("Moskvich").win("WIN000000").color("blue").build()
        ));
        String jsonText = objectMapper.writeValueAsString(cars);
        logger.info(jsonText);
        objectMapper.writeValue(new File("cars.json"), cars);
        objectMapper.writer(new DefaultPrettyPrinter()).writeValue(new File("prettyCars.json"), cars);
    }

    Car readCarTest() throws JsonProcessingException {
        return objectMapper.readValue(
                "{\"car-color\":\"yellow\",\"type\":\"renault\",\"win\":\"WWW\"}",
                Car.class);
    }

    private <T> T readCarFromResources(String fileName, Class<T> clazz) throws IOException {
        return objectMapper.readValue(Main.class.getClassLoader().getResourceAsStream(fileName), clazz);
    }

    private Map<String, Object> readAsMap() throws JsonProcessingException {
        return objectMapper.readValue(JSON_STRING, Map.class); //или new TypeReference<>() {});
    }

//    public static void main( String[] args ) throws IOException {
//
//        logger.fine("Starting...");
//        writeCarTest();
//        Car car1 = readCarTest();
//        logger.info(car1.toString());
//        Car car2 = readCarFromResources("car.json", Car.class);
//        logger.info(car2.toString());
//        Map<String, Object> map = readAsMap();
//        logger.info(map.toString());
//        CarsList cars = readCarFromResources("cars.json", CarsList.class);
//        logger.info(cars.toString());
//    }
}
