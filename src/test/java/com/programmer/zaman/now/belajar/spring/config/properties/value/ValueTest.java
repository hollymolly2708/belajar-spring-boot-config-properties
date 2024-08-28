package com.programmer.zaman.now.belajar.spring.config.properties.value;


import com.programmer.zaman.now.belajar.spring.config.properties.springbootmessagesource.SpringBootMessageSourceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {
    @Autowired
    private TestApplication.ApplicationProperties properties;
    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testSystemProperties() {
        Assertions.assertNotEquals("", systemProperties.getJavaHome());
        System.out.println(systemProperties.getJavaHome());

    }

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar Spring Boot Config Properties", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());

    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SystemProperties {
            @Value("${_JAVA_OPTIONS}")
            private String javaHome;

            public String getJavaHome() {
                return javaHome;
            }
        }

        @Component
        public static class ApplicationProperties {
            @Value("${application.name}")
            private String name;
            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;

            public String getName() {
                return name;
            }

            public Integer getVersion() {
                return version;
            }

            public boolean isProductionMode() {
                return productionMode;
            }

        }
    }
}
