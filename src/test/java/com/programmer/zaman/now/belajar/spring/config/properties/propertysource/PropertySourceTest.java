package com.programmer.zaman.now.belajar.spring.config.properties.propertysource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = PropertySourceTest.TestApplication.class)
public class PropertySourceTest {
    @Autowired
    private TestApplication.SampleProperties properties;

    @Test
    void testPropertySource() {
        Assertions.assertEquals("muhammad fiqri turham", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
    }

    @SpringBootApplication
    @PropertySources({
            @PropertySource("classpath:/sample.properties")
    })
    public static class TestApplication {
        @Component
        public static class SampleProperties {
            @Value("${sample.name}")
            private String name;
            @Value("${sample.version}")
            private Integer version;

            public String getName() {
                return name;
            }

            public Integer getVersion() {
                return version;
            }
        }

    }
}
