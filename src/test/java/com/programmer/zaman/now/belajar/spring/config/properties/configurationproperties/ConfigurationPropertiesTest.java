package com.programmer.zaman.now.belajar.spring.config.properties.configurationproperties;

import com.programmer.zaman.now.belajar.spring.config.properties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot Config Properties", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertEquals(false, applicationProperties.isProductionMode());

    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("fiqri", applicationProperties.getDatabaseProperties().getUsername());
        Assertions.assertEquals("rahasia", applicationProperties.getDatabaseProperties().getPassword());
        Assertions.assertEquals("belajar", applicationProperties.getDatabaseProperties().getDatabase());
        Assertions.assertEquals("jdbc:contoh", applicationProperties.getDatabaseProperties().getUrl());
    }

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabaseProperties().getWhiteListTables());
        Assertions.assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTableSize().get("products"));
        Assertions.assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTableSize().get("categories"));
        Assertions.assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTableSize().get("customers"));
    }

    @Test
    void testEmbeddedCollection() {
        Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role ", applicationProperties.getRoles().get("finance").getName());
    }


    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
