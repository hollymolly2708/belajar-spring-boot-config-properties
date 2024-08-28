package com.programmer.zaman.now.belajar.spring.config.properties.environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {
    @Autowired
    private Environment environment;

    @Test
    void testEnvironment() {
        String javaHome = environment.getProperty("JAVA_HOME");
        Assertions.assertNotEquals("C:\\Program Files\\Adoptium JDK\\jdk-11\\bin", javaHome);


    }

    @SpringBootApplication
    public static class TestApplication {

    }
}
