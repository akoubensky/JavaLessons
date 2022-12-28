package org.myproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main myMain;

    @BeforeEach
    void setUp() {
        myMain = new Main();
    }

    @Test
    void readCarTest() throws JsonProcessingException {
        Car testCar = myMain.readCarTest();
        Assertions.assertNotNull(testCar);
        Assertions.assertEquals("yellow", testCar.getColor());
        Assertions.assertEquals("reno", testCar.getType());
    }
}